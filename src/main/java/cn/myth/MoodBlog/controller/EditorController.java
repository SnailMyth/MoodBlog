package cn.myth.MoodBlog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EditorController {
	
	
	@RequestMapping(value = { "/editor"})
	public String writeView() {
		return "editor";
	}
	
}
