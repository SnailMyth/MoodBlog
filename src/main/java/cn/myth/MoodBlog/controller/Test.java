package cn.myth.MoodBlog.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.myth.MoodBlog.data.User;
import cn.myth.MoodBlog.service.LoginService;

@Controller
public class Test {
	@Autowired
	public LoginService service;

	@RequestMapping("/test/index")
	public ModelAndView index(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("test");
		User user = service.getUserById(6);
		// UserInfo userInfo = service.getUserInfo(user);
		mv.addObject("data", user);
		return mv;
	}

	@RequestMapping("/test")
	public String test() {
		return "test";
	}
	
	@RequestMapping("/article")
	public String article() {
		return "article";
	}
	
	@RequestMapping("/timeline")
	public String timeline() {
		return "timeline";
	}
	
}
