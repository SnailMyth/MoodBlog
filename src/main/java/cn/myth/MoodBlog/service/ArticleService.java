package cn.myth.MoodBlog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.myth.MoodBlog.data.Articles;
import cn.myth.MoodBlog.data.User;
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
	
	public List<Article> list(String id) {
		List<Articles> authorList = dao.authorList(new User(id));
		List<Article> r = new ArrayList<>();
		for (Articles article : authorList) {
			Article c = Article.createByDb(article);
			r.add(c);
		}
		return r;
	}

}
