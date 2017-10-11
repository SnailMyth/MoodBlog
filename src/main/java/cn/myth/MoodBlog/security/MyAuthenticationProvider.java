package cn.myth.MoodBlog.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import cn.myth.MoodBlog.data.User;
import cn.myth.MoodBlog.model.UserDetail;
import cn.myth.MoodBlog.repositories.UserDao;

public class MyAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	UserDao userDao;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		UserDetail user = new UserDetail();
		User dbUser = userDao.getUserByName(username);
		user.copyDbUser(dbUser);
		Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
		return new UsernamePasswordAuthenticationToken(user, password, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
