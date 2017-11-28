package cn.myth.MoodBlog.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public enum DateFormat {
	FORMAT_SHORT("yyyy-MM-dd"),
	FORMAT_LONG("yyyy-MM-dd HH:mm:ss"),
	FORMAT_FULL("yyyy-MM-dd HH:mm:ss.S"),
	FORMAT_SHORT_CN("yyyy��MM��dd��"),
	FORMAT_LONG_CN("yyyy��MM��dd��  HHʱmm��ss��"),
	FORMAT_FULL_CN("yyyy��MM��dd��  HHʱmm��ss��SSS����"),
	FORMAT_ROUNDNAME("yyMMddHHmmssSSS");
	;
	
	private String value;
	private DateFormat(String value) {
		this.value = value;
	}
	
	public String format(Date date) {
        String returnValue = "";
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(value);
            returnValue = df.format(date);
        }
        return (returnValue);
	}
	
	public String format(Date date,String pattern) {
        String returnValue = "";
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            returnValue = df.format(date);
        }
        return (returnValue);
	}
	
	public static void main(String[] args) {
		System.out.println(DateFormat.FORMAT_ROUNDNAME.format(new Date()));
	}
}
