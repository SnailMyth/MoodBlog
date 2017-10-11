package cn.myth.MoodBlog.model;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3164445450931569284L;
	
	private int id; 
	private String authority;
	private String des;

	@Override
	public String getAuthority() {
		return authority;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
