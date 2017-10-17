package cn.myth.MoodBlog.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import cn.myth.MoodBlog.data.User;
import cn.myth.MoodBlog.model.UserDetail;

public class MyUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetail detail = new UserDetail();
		
		User user = new User(username,"111");
		user.setActive(true);
		detail.copyDbUser(user);
		
		return detail;
	}

}
