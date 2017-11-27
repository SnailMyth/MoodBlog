package cn.myth.MoodBlog.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baidu.ueditor.ActionEnter;

@Controller
public class EditorController {
	
	
	@RequestMapping(value = { "/editor"})
	public String writeView() {
		return "editor";
	}
	
}
