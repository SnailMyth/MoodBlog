package cn.myth.MoodBlog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.myth.MoodBlog.data.Articles;
import cn.myth.MoodBlog.model.Article;
import cn.myth.MoodBlog.repositories.ArticleDao;

@Service
@Transactional
public class ArticleService {

	@Autowired
	public ArticleDao dao;

	public Article get(String id) {
		Articles articles = dao.findOne(Integer.parseInt(id));
		return Article.createByDb(articles);
	}

}
