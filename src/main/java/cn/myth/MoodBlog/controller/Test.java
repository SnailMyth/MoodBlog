package cn.myth.MoodBlog.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.myth.MoodBlog.entity.User;

@Controller
@RequestMapping("/test")
public class Test {

	@RequestMapping(value = "/index")
	public ModelAndView index(User p,HttpServletRequest req) {
		ModelAndView tmpMAV = new ModelAndView("index");
		System.out.println(p);
		req.getSession().setAttribute("user", p);
		return tmpMAV;
	}
}
