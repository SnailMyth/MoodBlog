package cn.myth.MoodBlog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import cn.myth.MoodBlog.StringUtils;
import cn.myth.MoodBlog.data.User;
import cn.myth.MoodBlog.model.UserDetail;
import cn.myth.MoodBlog.repositories.UserDao;

public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserDao dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = dao.getUserByName(username);
		UserDetail detail = new UserDetail().initByDB(user);
		StringUtils.printValue(MyUserDetailsService.class, "User", detail.toString());
		return detail;
	}

}
