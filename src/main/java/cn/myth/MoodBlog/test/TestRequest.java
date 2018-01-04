package cn.myth.MoodBlog.test;

import java.io.Serializable;

public class TestRequest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1069762017018570025L;
	
	private String id;
	private String msg;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "TestRequest [id=" + id + ", msg=" + msg + "]";
	}
	
	
}
