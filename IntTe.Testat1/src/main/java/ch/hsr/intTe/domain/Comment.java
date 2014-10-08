package ch.hsr.intTe.domain;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable{
	private static final long serialVersionUID = -4272793839234627484L;
	
	private String text;
	private Date date;
	private Post post;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	
}
