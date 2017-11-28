package cn.myth.MoodBlog.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.myth.MoodBlog.utils.ImageUploadUtil;

@Controller
public class EditorController {

	@RequestMapping(value = { "/editor" })
	public String writeView() {
		return "editor";
	}

	@RequestMapping(value = { "/editor/upload" })
	@ResponseBody
	public void imgupload(HttpServletRequest request, HttpServletResponse response) {
        String fileName = ImageUploadUtil.upload(request);
        // ���ckeditor����
        // imageContextPathΪͼƬ�ڷ�������ַ����upload/123.jpg,�Ǿ���·��
        String imageContextPath = "download/img?path="+fileName;
        response.setContentType("text/html;charset=UTF-8");
        //�����������
        String callback = request.getParameter("CKEditorFuncNum");
        try {
			PrintWriter writer = response.getWriter();
			writer.print("<script type=\\\"text/javascript\\\">");
			writer.print("window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + imageContextPath + "','')");
			writer.print("</script>");
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
