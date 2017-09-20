package cn.myth.MoodBlog.interceptor;

import java.util.stream.Stream;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.myth.MoodBlog.entity.User;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		String url = request.getServletPath();
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			Stream<Cookie> s = Stream.of(cookies);
			s.forEach(cookie -> System.out.println("name:" + cookie.getName() + "--- value:" + cookie.getValue()));
			System.out.println("post URL：" + url);
		}
		
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return false;
		}
		return true;
	}

}
