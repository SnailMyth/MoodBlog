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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.myth.MoodBlog.base.ApiModel;
import cn.myth.MoodBlog.base.BaseException;
import cn.myth.MoodBlog.base.Errors;
import cn.myth.MoodBlog.base.ResultData;
import cn.myth.MoodBlog.data.User;
import cn.myth.MoodBlog.service.LoginService;

@Controller
public class Login {

	@Autowired
	public LoginService service;

	@RequestMapping("/")
	public String index() {
		return "login";
	}

	@RequestMapping("/register")
	public String register() {
		return "register";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
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
			model.setData("login success!");
		} else {
			model.setError(result.getException());
		}
		return model;
	}

	@RequestMapping("/loginout")
	public void loginout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.getSession().removeAttribute("user");
		req.getSession().invalidate();
		resp.sendRedirect(req.getContextPath() + "/login");

	}
}