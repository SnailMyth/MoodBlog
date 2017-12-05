package cn.myth.MoodBlog.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.myth.MoodBlog.data.Articles;
import cn.myth.MoodBlog.data.User;
import cn.myth.MoodBlog.model.Article;
import cn.myth.MoodBlog.repositories.ArticlesDao;
import cn.myth.MoodBlog.repositories.UserDao;
import cn.myth.MoodBlog.utils.DateFormat;
import cn.myth.MoodBlog.utils.FileUtils;

@Service
@Transactional
public class EditorService {

	@Autowired
	public ArticlesDao artDao;
	
	@Autowired
	public UserDao userDao;

	public boolean add(Article article,String id) {
		User user = userDao.findOne(Integer.parseInt(id));
		String fileName = user.getUsername() + DateFormat.FORMAT_ROUNDNAME.format(new Date()) +".txt";
		FileUtils.saveFile(fileName, article.getContent());
		article.setFilePath(fileName);
		Articles art = Articles.initByModel(article);
		art.setAuthor(user);
		Articles res = artDao.saveAndFlush(art);
		return res != null;
	}


	
}
