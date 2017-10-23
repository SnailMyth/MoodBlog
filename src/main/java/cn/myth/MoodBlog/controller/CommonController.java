package cn.myth.MoodBlog.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.myth.MoodBlog.ReadUtils;

@Controller
public class CommonController {

	@RequestMapping("/download/img")
	public void timeline(@RequestParam(value = "path") String path, HttpServletResponse response) throws IOException {
		byte[] data = ReadUtils.readImageFile(path);
		if (data != null) {
			response.setContentType("image/png");
			OutputStream stream = response.getOutputStream();
			stream.write(data);
			stream.flush();
			stream.close();
		}
	}

}
