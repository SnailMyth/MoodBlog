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

import cn.myth.MoodBlog.StringUtils;
import cn.myth.MoodBlog.base.ApiModel;
import cn.myth.MoodBlog.base.BaseException;
import cn.myth.MoodBlog.base.Errors;
import cn.myth.MoodBlog.base.ResultData;
import cn.myth.MoodBlog.data.Roles;
import cn.myth.MoodBlog.data.User;
import cn.myth.MoodBlog.listener.ContentEvent;
import cn.myth.MoodBlog.service.LoginService;

@Controller
public class Login {

	 
    @Autowired  
    private ApplicationContext applicationContext;
    
	@Autowired
	public LoginService service;

	@RequestMapping(value = { "/", "/login" })
	public String main() {
		return "login";
	}

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

	@RequestMapping("/add")
	@ResponseBody
	public ApiModel add(User user, HttpServletRequest req) {
		ApiModel model = new ApiModel();
		if (user != null) {
			try {
				user.active();
				user.setRoles(new Roles(2, "ROLE_USER", "普通用户权限"));
				User get = service.addUser(user);
				req.getSession().setAttribute("user", get);
				model.setData(get);
			} catch (Exception e) {
				model.setError(BaseException.create(Errors.SAVE_FAIL, "user", e.getMessage()));
			}
		}
		return model;
	}

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
		StringUtils.printString(Login.class, "return accessDenied page");
		return "accessDenied";
	}
}