package cn.myth.MoodBlog.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.myth.MoodBlog.base.ApiModel;
import cn.myth.MoodBlog.base.ResultData;
import cn.myth.MoodBlog.data.User;
import cn.myth.MoodBlog.data.UserInfo;
import cn.myth.MoodBlog.service.LoginService;

@Controller
@RequestMapping("/test")
public class Test {
	@Autowired
	public LoginService service;

	@RequestMapping(value = "/index")
	public ModelAndView index(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("test");
		User user = service.getUserById(6);
		// UserInfo userInfo = service.getUserInfo(user);
		System.out.println(user);
		mv.addObject("data", user);
		return mv;
	}

	@RequestMapping(value = "/addinfo")
	public @ResponseBody ApiModel addInfo(@RequestParam("nick") String nick, @RequestParam("age") int age,
			@RequestParam("sex") String sex, HttpServletRequest req) {
		User user = (User) req.getSession().getAttribute("user");
		ResultData<UserInfo> result = new ResultData<>();
		UserInfo userinfo =null;
		System.out.println(userinfo);
		UserInfo info = service.addUserInfo(userinfo);
		if (null == info) {

		}
		result.setData(info);
		return null;

	}
}
