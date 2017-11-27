/**
 * 
 */
/**
 * @author myth_hai
 *
 */
package cn.myth.MoodBlog.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.myth.MoodBlog.base.ApiModel;
import cn.myth.MoodBlog.base.BaseException;
import cn.myth.MoodBlog.base.Errors;
import cn.myth.MoodBlog.base.ResultData;
import cn.myth.MoodBlog.data.User;
import cn.myth.MoodBlog.listener.ContentEvent;
import cn.myth.MoodBlog.service.LoginService;
import cn.myth.MoodBlog.utils.StringUtils;

/**
 * 
 * @author myth_hai
 * @group Login
 */
@Controller
public class LoginController {

	 
    @Autowired  
    private ApplicationContext applicationContext;
    
	@Autowired
	public LoginService service;

	@RequestMapping(value = { "/", "/login" })
	public String main() {
		return "login";
	}

	/**
	 * 
	 * @name index
	 * @description  主页显示
	 * @method get
	 * @return text/html
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest req) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			User user = service.getUserByName(((UserDetails) principal).getUsername());
			req.getSession().setAttribute("user", user);
			applicationContext.publishEvent(new ContentEvent(user.getUsername() + " 登陆成功"));
		}
		return "index";
	}

	@RequestMapping("/register")
	public String register() {
		return "register";
	}

	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}

	/**
	 * 
	 * @name add
	 * @description 添加用户
 	 * @url http://localhost/MoodBolg/add
	 * @method put
	 * @param username String 用户名 
	 * @param password String 用户密码
	 * @return {"message":"注册成功","code":"0"}
	 */
	@RequestMapping("/add")
	@ResponseBody
	public ApiModel add(User user, HttpServletRequest req) {
		ApiModel model = new ApiModel();
		if (user != null) {
			try {
				User get = service.addUser(user);
				req.getSession().setAttribute("user", get);
				model.setData(get);
			} catch (Exception e) {
				model.setError(BaseException.create(Errors.SAVE_FAIL, "user", e.getMessage()));
			}
		}
		return model;
	}

	/**
	 * 
	 * @name   login
	 * @description  登陆接口
	 * @url http://www.baidu.com
	 * @method get
	 * @param username String 用户名
	 * @param username String 密码
	 * @return {"message":"参数错误","nu":"","ischeck":"0","condition":"","com":"","status":"400","state":"0","data":[]}
	 * @throws IOException
	 */
	@RequestMapping("/check")
	@ResponseBody
	public ApiModel check(User user, HttpServletRequest req, HttpServletResponse resp) throws IOException {
		ApiModel model = new ApiModel();
		ResultData<User> result = service.login(user);
		if (result.isSuccess()) {
			User loginUser = result.getData();
			req.getSession().setAttribute("user", loginUser);
			applicationContext.publishEvent(new ContentEvent(user.getUsername() + "登陆成功"));
			model.setData("login success!");
		} else {
			model.setError(result.getException());
		}
		return model;
	}

	@RequestMapping("/loginout")
	public void loginout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String username = ((User) req.getSession().getAttribute("user")).getUsername();
		applicationContext.publishEvent(new ContentEvent(username + " 注销系统"));
		req.getSession().removeAttribute("user");
		req.getSession().invalidate();
		resp.sendRedirect(req.getContextPath() + "/");
		
	}

	@RequestMapping("/accessDenied")
	public String accessDenied() {
		StringUtils.printString(LoginController.class, "return accessDenied page");
		return "accessDenied";
	}
	
	
	@RequestMapping("/me")
	public String timeline() {
		return "me";
	}
}