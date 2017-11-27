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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.myth.MoodBlog.base.ApiModel;
import cn.myth.MoodBlog.model.Article;
import cn.myth.MoodBlog.service.ArticleService;

/**
 * 
 * @author myth_hai
 * @group  article
 */
@Controller
public class ArticleController {
    
	@Autowired
	public ArticleService service;

	@RequestMapping(value = { "/blog"})
	public String getView() {
		return "article";
	}
	
	/**
	 * 
	 * @description  获取文章内容
	 * @param authorId  作者id
	 * @return null
	 */
	@RequestMapping(value = { "/blog/get/{id}"})
	@ResponseBody
	public  ApiModel getArticle(@PathVariable(name="id") String articleId) {
		ApiModel model = new ApiModel();
		Article article = service.get(articleId);
		model.setData(article);
		System.out.println(article);
		return model;
	}
}