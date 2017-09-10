/**
 * 
 */
/**
 * @author myth_hai
 *
 */
package cn.myth.MoodBlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.myth.MoodBlog.base.BaseException;
import cn.myth.MoodBlog.base.MythError;
import cn.myth.MoodBlog.base.ResultData;
import cn.myth.MoodBlog.entity.User;
import cn.myth.MoodBlog.service.UserService;

@Controller
public class Login {

	@Autowired
	public UserService service;
	
	@RequestMapping("/")
	public @ResponseBody String index() {
		return "index";
	}

	@RequestMapping("/login")
	@ResponseBody
	public ResultData<User> login() {

		User user = new User();
		user.setUsername("myth_hai");
		user.setId(1);
//		user.setPasswd("1111");
		service.addUser(user);
	
		User user1 = service.getUser("1");
		ResultData<User> data = new ResultData<User>();
		data.setData(user1);
		return data;
	}

	@RequestMapping("/error")
	@ResponseBody
	public ResultData<BaseException> error() {
		BaseException exception = new BaseException();
		exception.setError(MythError.ID_EXSIT);

		ResultData<BaseException> data = new ResultData<BaseException>();
		data.setData(exception);
		return data;
	}
}