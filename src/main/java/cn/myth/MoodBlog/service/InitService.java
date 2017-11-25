package cn.myth.MoodBlog.service;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.myth.MoodBlog.data.Articles;
import cn.myth.MoodBlog.data.Resource;
import cn.myth.MoodBlog.data.Roles;
import cn.myth.MoodBlog.data.User;
import cn.myth.MoodBlog.repositories.ArticleDao;
import cn.myth.MoodBlog.repositories.RescDao;
import cn.myth.MoodBlog.repositories.RolesDao;
import cn.myth.MoodBlog.repositories.UserDao;
import cn.myth.MoodBlog.utils.StringUtils;

@Component
public class InitService {
	@Autowired
	UserDao userDao;
	@Autowired
	ArticleDao articleDao;
	@Autowired
	RolesDao rolesDao;
	@Autowired
	RescDao rescDao;

	private static String ROOT = null;

	@PostConstruct
	public void init() {
		ROOT = System.getProperty("user.dir")+"/";

		Roles role1 = new Roles(1, "ROLE_ADMIN", "管理员权限");
		Roles role2 = new Roles(2, "ROLE_USER", "普通用户权限");
		rolesDao.save(role1);
		rolesDao.save(role2);

		Resource res1 = new Resource(1, "index", "URL", "/index", "主页", role2);
		Resource res2 = new Resource(2, "admin", "URL", "/admin", "后台界面入口", role1);
		Resource res3 = new Resource(3, "admin", "URL", "/index", "后台界面入口", role1);
		rescDao.save(res1);
		rescDao.save(res2);
		rescDao.save(res3);

		User admin = new User(1, "admin", "111", true, role1);
		userDao.save(admin);
		User user = new User(2, "myth", "111", true, role2);
		userDao.save(user);

		Articles article = new Articles(user, "情书，爱的注脚", new Date(1511424515000L), "/aaa.txt");
		Articles article1 = new Articles(user, "test1", new Date(1511424525000L), "/aaa1.txt");
		Articles article2 = new Articles(user, "test2", new Date(1511424535000L), "/aaa2.txt");
		article.setId(1);
		article1.setId(2);
		article2.setId(3);
		articleDao.save(article);
		articleDao.save(article1);
		articleDao.save(article2);

		StringUtils.printString(InitService.class, "初始化数据......");
	}

	public static String getRoot() {
		return (ROOT != null) ? ROOT : "";
	}
}
