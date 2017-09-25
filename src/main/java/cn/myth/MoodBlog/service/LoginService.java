package cn.myth.MoodBlog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.myth.MoodBlog.entity.User;
import cn.myth.MoodBlog.repositories.LoginDao;

@Service
@Transactional
public class LoginService {

	@Autowired
	public LoginDao dao;

	public User getUser(int id) {
		User user = dao.findOne(id);
		return user;
	}

	public User getUserByName(String username) {
		User user = dao.getUserByName(username);
		return user;
	}

	public void addUser(User user) {
		dao.save(user);
	}

	public boolean login(User user) {
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
