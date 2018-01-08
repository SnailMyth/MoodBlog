package cn.myth.MoodBlog.test;

import java.io.Serializable;

public class TestResponse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1089556797673521380L;
	private String id;
	private String rep;
	public TestResponse() {
		
	}
	public TestResponse(String i) {
		this.id = i;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRep() {
		return rep;
	}
	public void setRep(String rep) {
		this.rep = rep;
	}
	@Override
	public String toString() {
		return "TestResponse [id=" + id + ", rep=" + rep + "]";
	}
	
}
