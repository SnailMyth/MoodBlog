/**
 * 
 */
/**
 * @author myth_hai
 *
 */
package cn.myth.MoodBlog.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class MeController {
    
	@Autowired
	public ArticleService service;
	
	/**
	 * 
	 * @description  获取文章内容
	 * @param authorId  作者id
	 * @return null
	 */	
	@RequestMapping(value = { "/me/list/{id}"})
	@ResponseBody
	public ApiModel getList(@PathVariable(name="id") String authorId) {
		ApiModel model = new ApiModel();
		List<Article> list = service.list(authorId);
		Map<String, List<Article>> data = new HashMap<>();
		for (Article article : list) {
			Calendar date = Calendar.getInstance();
			date.setTime(article.getTime());
			String year = date.get(Calendar.YEAR)+"";
			String month = date.get(Calendar.MONTH)+"";
			String key = year+"/"+month;
			if (data.containsKey(key)) {
					data.get(key).add(article);
			}else{
				List<Article> l = new ArrayList<>();
				l.add(article);
				data.put(key, l);
			}
		}
		
		model.setData(data);
		return model;
	}
}