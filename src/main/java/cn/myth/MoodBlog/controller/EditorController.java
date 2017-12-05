package cn.myth.MoodBlog.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.myth.MoodBlog.base.ApiModel;
import cn.myth.MoodBlog.model.Article;
import cn.myth.MoodBlog.service.EditorService;
import cn.myth.MoodBlog.utils.ImageUploadUtil;

@Controller
public class EditorController {

	@Autowired
	private EditorService service;

	@RequestMapping(value = { "/editor" })
	public String writeView() {
		return "editor";
	}

	@RequestMapping(value = { "/editor/upload" })
	@ResponseBody
	public void imgupload(HttpServletRequest request, HttpServletResponse response) {
		String fileName = ImageUploadUtil.upload(request);

		String imageContextPath = "download/img?path=" + fileName;
		response.setContentType("text/html;charset=UTF-8");

		String callback = request.getParameter("CKEditorFuncNum");
		try {
			PrintWriter writer = response.getWriter();
			writer.print("<script type=\"text/javascript\">");
			writer.print("window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + imageContextPath + "','')");
			writer.print("</script>");
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = { "/editor/add" })
	@ResponseBody
	public ApiModel add(@RequestParam("id") String id, @RequestParam("title") String title,
			@RequestParam("tag") String tag, @RequestParam("content") String content) {
		Article art = new Article(Integer.parseInt(id), title, new Date(), content, "");
		boolean add = service.add(art,id);
		ApiModel m = new ApiModel();
		m.setData(add);
		return m;
	}

}
