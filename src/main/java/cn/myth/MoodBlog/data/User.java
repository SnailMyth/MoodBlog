package cn.myth.MoodBlog.data;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import cn.myth.MoodBlog.base.Jsons;

@SuppressWarnings("serial")
@Entity
@Table(name = "user")
public class User implements Serializable {
	@Id
	@Column(name = "id", nullable = false, unique = true)
	@GenericGenerator(name = "generator", strategy = "native")
	@GeneratedValue(generator="generator")
	private int id;
	@Column(name = "username", nullable = false, unique = true, length = 32)
	private String username;
	@Column(name = "passwd", nullable = false, unique = false, length = 32)
	private String passwd;
	@Column(name = "active", nullable = false, unique = false)
	private boolean active = false;
	
	@OneToOne
	@JoinColumn(name = "role_id")
	private Roles roles;
	

	
	public User() {
	}
	

	public User(int id, String username, String passwd, boolean active, Roles roles) {
		this.id = id;
		this.username = username;
		this.passwd = passwd;
		this.active = active;
		this.roles = roles;
	}


	public User(String username, String passwd) {
		this.username = username;
		this.passwd = passwd;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public User(int id, String username, String passwd) {
		super();
		this.id = id;
		this.username = username;
		this.passwd = passwd;
	}
	
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return Jsons.i.toJson(this);
	}

	public void active() {
		this.setActive(true);
	}
	
}
