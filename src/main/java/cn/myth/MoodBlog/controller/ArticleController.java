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

	@RequestMapping(value = { "/article"})
	public String getView() {
		return "article";
	}
	
	/**
	 * 
	 * @name  getArticle
	 * @description  获取文章内容
	 * @url http://localhost/MoodBolg//article/get/{id}
	 * @method get
	 * @param authorId int 作者id
	 * @return null
	 */
	@RequestMapping(value = { "/article/get/{id}"})
	@ResponseBody
	public  ApiModel getArticle(@PathVariable(name="id") String authorId) {
		ApiModel model = new ApiModel();
		Article article = service.get(authorId);
		model.setData(article);
		return model;
	}

}