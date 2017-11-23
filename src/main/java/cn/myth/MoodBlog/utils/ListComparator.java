package cn.myth.MoodBlog.utils;

import java.util.Comparator;
import java.util.Date;

public class ListComparator implements Comparator<Object>{
	private String properity = null;
	
	public ListComparator(String properity) {
		this.properity = properity;
	}
	@Override
	public int compare(Object o1, Object o2) {
		if (o1.getClass() != o2.getClass()) {
			return 0;
		}
		
		if (o1 instanceof Date) {
			
		}
		if (o1 instanceof Integer) {
			
		}
		return 0;
	}
	public static void main(String[] args) {
		
	}

}
