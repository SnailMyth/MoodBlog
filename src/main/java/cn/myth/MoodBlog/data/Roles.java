package cn.myth.MoodBlog.data;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "role")
public class Roles implements Serializable {

	@Id
	@Column(name = "id", nullable = false, unique = true)
	private int id;
	@Column(name = "name", nullable = false, unique = false, length = 32)
	private String name;
	@Column(name = "des", nullable = false, unique = false, length = 32)
	private String des;

	@OneToMany(mappedBy="roles")
	private List<Resource> res;

	public Roles() {

	}

	public List<Resource> getRes() {
		return res;
	}

	public void setRes(List<Resource> res) {
		this.res = res;
	}

	public Roles(int id, String name, String des) {
		this.id = id;
		this.name = name;
		this.des = des;
//		this.res = res;
	}
	public Roles( String name, String des) {
		this.name = name;
		this.des = des;
//		this.res = res;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	@Override
	public String toString() {
		return "Roles [id=" + id + ", name=" + name + ", des=" + des + ", res=" + res + "]";
	}
}
