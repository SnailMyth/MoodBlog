package cn.myth.MoodBlog.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import cn.myth.MoodBlog.utils.StringUtils;

@Component
public class BaseExceptionResolver extends AbstractHandlerExceptionResolver {
	

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ex.printStackTrace();
		StringUtils.printString(BaseExceptionResolver.class, ex.getMessage());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error");
		mv.addObject("ex", ex);
		return mv;
	}
}
