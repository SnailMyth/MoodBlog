package cn.myth.MoodBlog.model;

import java.util.Date;

import cn.myth.MoodBlog.data.Articles;

public class Article {
	private int id;
	private int authorId;
	private String title;
	private Date time;
	private String content;
	private String des;
	private String filePath;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Article(int authorId, String title, Date time, String content,String path) {
		this.authorId = authorId;
		this.title = title;
		this.time = time;
		this.content = content;
		if (content.length() >= 30) {
			this.des = content.substring(0, 29);
		} else {
			this.des = content;
		}
		this.filePath = path;
	}

	public Article(int authorId, String title, Date time, String content, String des,String path) {
		this.authorId = authorId;
		this.title = title;
		this.time = time;
		this.content = content;
		this.des = des;
		this.filePath = path;
	}

	public static Article createByDb(Articles articles) {
		Article article = new Article(articles.getAuthor().getId(), articles.getTitle(), articles.getTime(),
				articles.getContent(),articles.getAtlpath());
		article.setId(articles.getId());
		return article;
	}

}
