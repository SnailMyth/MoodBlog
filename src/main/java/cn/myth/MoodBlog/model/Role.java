package cn.myth.MoodBlog.model;

import org.springframework.security.core.GrantedAuthority;

import cn.myth.MoodBlog.data.Roles;

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
	
	public Role initByDB(Roles roles) {
		this.id=roles.getId();
		this.des=roles.getDes();
		this.authority=roles.getName();
		return this;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", authority=" + authority + ", des=" + des + "]";
	}

}
