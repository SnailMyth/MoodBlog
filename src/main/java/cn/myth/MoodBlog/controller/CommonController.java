package cn.myth.MoodBlog.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.myth.MoodBlog.ReadUtils;
/**
 * 
 * @author myth_hai
 * @group common
 */
@Controller
public class CommonController {

	/**
	 * 
	 * @name download
	 * @description 下载文件接口
	 * @url http://localhost/MoodBolg/download/img
	 * @method get
	 * @param fileName String 文件名称
	 * @throws IOException
	 */
	@RequestMapping("/download/img")
	public void timeline(@RequestParam(value = "path") String fileName, HttpServletResponse response) throws IOException {
		byte[] data = ReadUtils.readImageFile(fileName);
		if (data != null) {
			response.setContentType("image/png");
			OutputStream stream = response.getOutputStream();
			stream.write(data);
			stream.flush();
			stream.close();
		}
	}

}
