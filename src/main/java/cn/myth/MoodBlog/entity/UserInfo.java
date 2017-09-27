package cn.myth.MoodBlog.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "userinfo")
public class UserInfo implements Serializable {

	private String nick;
	private String sex;
	private int age;
	private int id;

	@Id
	@Column(name = "id", nullable = false, unique = true)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserInfo() {

	}

	public UserInfo(String nickname, String sex, int age, int id) {
		this.nick = nickname;
		this.sex = sex;
		this.age = age;
		this.id = id;
	}

	@Column(name = "nick", nullable = false, unique = false, length = 30)
	public String getNickname() {
		return nick;
	}

	public void setNickname(String nickname) {
		this.nick = nickname;
	}

	@Column(name = "sex", nullable = false, unique = false, length = 30)
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "age", nullable = false, unique = false, length = 11)
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserInfo [nick=" + nick + ", sex=" + sex + ", age=" + age + ", id=" + id + "]";
	}

	public UserInfo(String nickname, String sex, int age) {
		this.nick = nickname;
		this.sex = sex;
		this.age = age;
	}
}
