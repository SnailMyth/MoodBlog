package cn.myth.MoodBlog.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.myth.MoodBlog.base.BaseException;
import cn.myth.MoodBlog.base.Errors;
import cn.myth.MoodBlog.base.ResultData;
import cn.myth.MoodBlog.data.Roles;
import cn.myth.MoodBlog.data.User;
import cn.myth.MoodBlog.data.UserInfo;
import cn.myth.MoodBlog.repositories.UserDao;
import cn.myth.MoodBlog.repositories.UserInfoDao;

@Service
@Transactional
public class LoginService {

	@Autowired
	public UserDao dao;

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

	public User addUser(User user) {
		user.active();
		user.setRoles(new Roles(2, "ROLE_USER", "普通用户权限"));
		User save = dao.save(user);
		UserInfo info = new UserInfo();
		info.setId(save.getId());
		info.setRegisterTime(new Date());
		info.setNick("新用户" + (100000 + save.getId()));
		infoDao.save(info);
		return user;
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

	public ResultData<User> login(User user) {
		ResultData<User> result = new ResultData<>();
		User res = dao.getUserByName(user.getUsername());
		if (res != null) {
			if (!user.getPasswd().equals(res.getPasswd())) {
				result.setException(BaseException.create(Errors.Login_FAIL, "password is wrong"));
			}else {
				result.setData(res);
			}
		} else {
			result.setException(BaseException.create(Errors.Login_FAIL, "user not exsist"));
		}
		return result;
	}

}
