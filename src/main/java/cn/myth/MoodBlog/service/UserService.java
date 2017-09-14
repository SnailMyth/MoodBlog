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
		User user = dao.getUserById(id);
		return user;
	}
	
	public User getUserByName(String username) {
		User user = dao.getUserByName(username);
		return user;
	}

	public void addUser(User user) {
			dao.addUser(user);
	}
	
	
	public boolean login(User user){
		boolean result = false;
		User res = dao.getUserByName(user.getUsername());
		if (res != null) {
			if (user.getPasswd().equals(res.getPasswd())) {
				result = true;
			}
		}
		
		return result;
	}

}
