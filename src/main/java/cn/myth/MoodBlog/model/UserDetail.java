
package cn.myth.MoodBlog.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import cn.myth.MoodBlog.data.User;

public class UserDetail implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4371214684188591486L;

	private String username;

	private String password;

	private boolean disabled = false;

	private List<Role> roles;

	public String getAuthoritiesString() {
		List<String> authorities = new ArrayList<String>();
		for (GrantedAuthority authority : this.getAuthorities()) {
			authorities.add(authority.getAuthority());
		}
		return StringUtils.join(authorities, ",");
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (roles == null || roles.isEmpty()) {
			List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
			GrantedAuthority au = new SimpleGrantedAuthority("ROLE_ADMIN");
			list.add(au);
			return list;
		}
		return roles;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return disabled;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return disabled;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return disabled;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return disabled;
	}

	public UserDetail initByDB(User user) {
		this.username = user.getUsername();
		this.password = user.getPasswd();
		this.disabled = user.isActive();
		if (user.getRoles() != null) {
			if (roles == null) {
				roles = new ArrayList<>();
			} else {
				roles.clear();
			}
			roles.add(new Role().initByDB(user.getRoles()));
		}
		return this;
	}

	@SuppressWarnings("unchecked")
	public void addRole(Collection<? extends GrantedAuthority> authorities) {
		if (authorities != null) {
			roles = (List<Role>) authorities;
		}
	}

	@Override
	public String toString() {
		return "UserDetail [username=" + username + ", password=" + password + ", disabled=" + disabled + ", roles="
				+ roles + "]";
	}
	
	

}
