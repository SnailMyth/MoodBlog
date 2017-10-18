package cn.myth.MoodBlog.listener;

import org.springframework.context.ApplicationEvent;

@SuppressWarnings("serial")
public class ContentEvent extends ApplicationEvent {

	public ContentEvent(final String source) {
		super(source);
	}
}
