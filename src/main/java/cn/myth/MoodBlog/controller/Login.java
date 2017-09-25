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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.myth.MoodBlog.base.ResultData;
import cn.myth.MoodBlog.entity.User;
import cn.myth.MoodBlog.service.LoginService;

@Controller
public class Login {

	@Autowired
	public LoginService service;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/register")
	public String register() {
		return "register";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/add")
	@ResponseBody
	public ResultData<Boolean> add(@RequestParam("username") String username,
			@RequestParam("password") String password) {

		User user = new User();
		user.setUsername(username);
		user.setPasswd(password);
		ResultData<Boolean> data = new ResultData<Boolean>();
		service.addUser(user);
		data.setData(false);
		data.setData(true);
		return data;
	}

	@RequestMapping("/check")
	public void check(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpServletRequest req, HttpServletResponse resp) throws IOException {
		User user = new User();
		user.setPasswd(password);
		user.setUsername(username);
		if (service.login(user)) {
			req.getSession().setAttribute("user", user);
			resp.sendRedirect(req.getContextPath() + "/");
		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}

	@RequestMapping("/loginout")
	public void loginout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.getSession().removeAttribute("user");
		req.getSession().invalidate();
		resp.sendRedirect(req.getContextPath() + "/login");

	}
}