package cn.myth.MoodBlog.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@SuppressWarnings("serial")
@Entity
@Table(name = "userinfo")
public class UserInfo implements Serializable {

	private int id;
	private String nickname;
	private String sex;
	private int age;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn()
	private User user;

	public UserInfo() {
		
	}

	public UserInfo(String nickname, String sex, int age, User user) {
		this.nickname = nickname;
		this.sex = sex;
		this.age = age;
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Id
	@Column(name = "id", nullable = false, unique = true)
	@GenericGenerator(name = "generator", strategy = "native")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "nick", nullable = false, unique = false, length = 30)
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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

	public UserInfo(String nickname, String sex, int age) {
		this.nickname = nickname;
		this.sex = sex;
		this.age = age;
	}
}
