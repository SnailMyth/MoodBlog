package cn.myth.MoodBlog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.myth.MoodBlog.base.BaseException;
import cn.myth.MoodBlog.base.Errors;
import cn.myth.MoodBlog.base.Result;
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

	public UserInfo addUserInfo(UserInfo userinfo) {
		UserInfo save = null;
		User user = dao.findOne(userinfo.getId());
		if (user != null) {
			save = infoDao.save(userinfo);
		}
		return save;
	}

	public UserInfo getUserInfo(User user) {
		// return infoDao.findInfo(user.getId());
		return null;
	}

	public Result login(User user) {
		Result result = new Result();
		User res = dao.getUserByName(user.getUsername());
		if (res != null) {
			if (!user.getPasswd().equals(res.getPasswd())) {
				result.setException(BaseException.create(Errors.Login_FAIL, "password is wrong"));
			}
		}else {
			result.setException(BaseException.create(Errors.Login_FAIL, "user not exsist"));
		}
		return result;
	}

}
