package cn.myth.MoodBlog.data;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	
	@ManyToOne
	@JoinColumn(name = "res_id")
	private Resource res;
	
	
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
	
}
