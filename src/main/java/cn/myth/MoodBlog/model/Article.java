package cn.myth.MoodBlog.model;

import java.util.Date;

import com.sun.istack.internal.Nullable;

import cn.myth.MoodBlog.data.Articles;

public class Article {
	private int id;
	private int authorId;
	private String title;
	private Date time;
	private String picPath;
	private String content;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAuthor_id() {
		return authorId;
	}

	public void setAuthor_id(int author_id) {
		this.authorId = author_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Article(int authorId, String title, Date time, @Nullable String picPath, String atlpath) {
		this.authorId = authorId;
		this.title = title;
		this.time = time;
		this.picPath = picPath;
		this.content = atlpath;
	}

	public Article(int authorId, String title, Date time, String atlpath) {
		this(authorId, title, time, null, atlpath);
	}

	public static Article createByDb(Articles articles) {
		Article article = new Article(articles.getAuthor().getId(), articles.getTitle(), articles.getTime(),
				articles.getContent());
		article.setId(articles.getId());
		return article;
	}

}
