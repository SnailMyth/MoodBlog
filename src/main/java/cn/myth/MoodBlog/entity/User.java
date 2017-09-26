package cn.myth.MoodBlog.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@SuppressWarnings("serial")
@Entity
@Table(name = "user")
public class User implements Serializable {
	private int id;
	private String username;
	private String passwd;
	
	

	public User() {
	}

	public User(String username, String passwd) {
		this.username = username;
		this.passwd = passwd;
	}

	@Id
	@Column(name = "id", nullable = false, unique = true)
	@GenericGenerator(name = "generator", strategy = "native")
	@GeneratedValue(strategy= GenerationType.AUTO)
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

	@Column(name = "passwd", nullable = false, unique = true, length = 50)
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

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", passwd=" + passwd + "]";
	}

}
