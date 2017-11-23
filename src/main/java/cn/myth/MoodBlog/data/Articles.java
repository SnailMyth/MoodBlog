package cn.myth.MoodBlog.data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.util.StringUtils;

import com.sun.istack.internal.Nullable;

import cn.myth.MoodBlog.base.Measurement;
import cn.myth.MoodBlog.utils.ReadUtils;

@SuppressWarnings("serial")
@Entity
@Table(name = "article")
public class Articles implements Serializable {

	@Id
	@Column(name = "id", nullable = false, unique = true)
	@GenericGenerator(name = "generator", strategy = "native")
	@GeneratedValue(generator = "generator")
	private int id;

	@OneToOne
	@JoinColumn(name = "author")
	private User author;

	@Column(name = "title", nullable = false)
	private String title;
	@Column(name = "time", nullable = false)
	private Date time;
	@Column(name = "havePics")
	private boolean havePics;
	@Column(name = "picPath", unique = true)
	private String picPath;
	@Column(name = "atlpath", unique = true)
	private String atlpath;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
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

	public boolean isHavePics() {
		return havePics;
	}

	public void setHavePics(boolean havePics) {
		this.havePics = havePics;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public Articles() {
		// TODO Auto-generated constructor stub
	}

	public Articles(User author, String title, Date time, boolean havePics, @Nullable String picPath, String atlpath) {
		super();
		this.author = author;
		this.title = title;
		this.time = time;
		this.havePics = havePics;
		this.picPath = picPath;
		this.atlpath = atlpath;
	}

	public Articles(User author, String title, Date time, String atlpath) {
		this(author, title, time, false, null, atlpath);
	}

	public static String getArtPath(Articles atl) {
		StringBuffer atlpat = new StringBuffer();
		int authorId = atl.getAuthor().getId();
		int artId = atl.getId();
		int[] numbers = { 10000, 1000, 100, 10, 1 };
		for (int i = 0; i < Measurement.Million.getNumber(); i++) {

			if ((authorId / numbers[i]) > 1) {
				atlpat.append(authorId);
				break;
			} else {
				atlpat.append("0");
			}
		}

		for (int i = 0; i < Measurement.Thousand.getNumber(); i++) {

			if ((artId / numbers[i]) > 1) {
				atlpat.append(artId);
				break;
			} else {
				atlpat.append("0");
			}
		}
		return atlpat.toString();
	}

	public String getContent() {
		if (!StringUtils.isEmpty(atlpath)) {
			String content = ReadUtils.readFileByLines(atlpath);
			content = content
					.replaceAll("<MoodBlog>image=", "<div align=\"center\" style=\"margin-bottom: 10px;\"><img src=\"download/img?path=")
					.replaceAll("</MoodBlog>", "\"></div>");
			return content;
		}
		return "";
	}
}
