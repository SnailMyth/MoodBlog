/**
 * 
 */
/**
 * @author myth_hai
 *
 */
package cn.myth.MoodBlog.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Login {

	@RequestMapping("/")
	public @ResponseBody String index() {
		return "index";
	}

	@RequestMapping("/login")
	@ResponseBody
	public Map<String, Object> login() {
		Map<String, Object> map = new HashMap<>();
		map.put("data", "login");
		map.put("code", 200);
		return map;
	}
}