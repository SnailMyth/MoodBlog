package cn.myth.MoodBlog.data;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import cn.myth.MoodBlog.base.Jsons;

@SuppressWarnings("serial")
@Entity
@Table(name = "user")
public class User implements Serializable {
	private int id;
	private String username;
	private String passwd;
	private boolean active = false;

	

	public User() {
		
	}

	public User(String username, String passwd) {
		this.username = username;
		this.passwd = passwd;
	}

	@Id
	@Column(name = "id", nullable = false, unique = true)
	@GenericGenerator(name = "generator", strategy = "native")
	@GeneratedValue(generator="generator")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "username", nullable = false, unique = true, length = 32)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "passwd", nullable = false, unique = false, length = 32)
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
	
	@Column(name = "active", nullable = false, unique = false)
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
