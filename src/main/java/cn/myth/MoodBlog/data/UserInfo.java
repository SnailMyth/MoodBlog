package cn.myth.MoodBlog.data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "userinfo")
public class UserInfo implements Serializable {

	@Id
	@Column(name = "id", nullable = false, unique = true)
	private int id;
	@Column(name = "nick", nullable = false, unique = false, length = 32)
	private String nick;
	@Column(name = "avator", nullable = true, unique = false)
	private String avator;
	@Column(name = "avatorPath", nullable = true, unique = false)
	private String avatorPath;
	@Column(name = "registerTime", nullable = false, unique = false)
	private Date registerTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserInfo() {

	}

	public UserInfo(String nickname) {
		this.nick = nickname;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	@Column(name = "nick", nullable = true, unique = false, length = 50)
	public String getAvator() {
		return avator;
	}

	public void setAvator(String avator) {
		this.avator = avator;
	}

	public String getAvatorPath() {
		return avatorPath;
	}

	public void setAvatorPath(String avatorPath) {
		this.avatorPath = avatorPath;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	
	
	
}
