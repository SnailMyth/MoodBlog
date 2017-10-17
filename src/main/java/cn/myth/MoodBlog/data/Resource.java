package cn.myth.MoodBlog.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "resc")
public class Resource {
	@Id
	@Column(name = "id", nullable = false, unique = true)
	@GenericGenerator(name = "generator", strategy = "native")
	@GeneratedValue(generator = "generator")
	private int id;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "res_type", nullable = false)
	private String type;
	@Column(name = "res_string", nullable = false)
	private String resString;
	@Column(name = "des")
	private String des;

	public Resource() {
		// TODO Auto-generated constructor stub
	}

	public Resource(int id, String name, String type, String resString, String des) {
		this.name = name;
		this.id = id;
		this.type = type;
		this.resString = resString;
		this.des = des;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getResString() {
		return resString;
	}

	public void setResString(String resString) {
		this.resString = resString;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}
}
