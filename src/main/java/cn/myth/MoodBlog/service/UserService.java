package cn.myth.MoodBlog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.myth.MoodBlog.dao.UserDao;
import cn.myth.MoodBlog.entity.User;

@Transactional
@Service
public class UserService {

	@Autowired
	public UserDao dao;

	public User getUser(String id) {
		return dao.getUserById(id);
	}

	public void addUser(User user) {
		dao.addUser(user);
	}

}
