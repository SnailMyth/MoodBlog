package cn.myth.MoodBlog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.myth.MoodBlog.base.BaseException;
import cn.myth.MoodBlog.entity.User;
import cn.myth.MoodBlog.entity.UserInfo;
import cn.myth.MoodBlog.repositories.LoginDao;
import cn.myth.MoodBlog.repositories.UserInfoDao;

@Service
@Transactional
public class LoginService {

	@Autowired
	public LoginDao dao;
	
	@Autowired
	public UserInfoDao infoDao;
	
	public User getUser(int id) {
		User user = dao.findOne(id);
		return user;
	}

	public User getUserByName(String username) {
		User user = dao.getUserByName(username);
		return user;
	}
	
	public User getUserById(int id) {
		User user = dao.getUserById(id);
		return user;
	}

	public void addUser(User user) {
		dao.save(user);
	}
	
	public void addUserInfo(UserInfo userinfo) {
		User user = dao.findOne(userinfo.getId());
		if (user != null) {
			infoDao.save(userinfo);
		}else {
			throw new BaseException("user not exsist");
		}
	}
	
	public UserInfo getUserInfo(User user) {
//		return infoDao.findInfo(user.getId());
		return null;
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
