package cn.myth.MoodBlog.base;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.servlet.ModelAndView;

public class ApiMode extends ModelAndView {
	private static final String DATA = "data";
	Map<String, Object> map;

	public ApiMode() {
		map = new ConcurrentHashMap<String, Object>();
		map.put(DATA, map);
	}

	public void put(String key, String value) {
		map.put(key, value);
	}

}
