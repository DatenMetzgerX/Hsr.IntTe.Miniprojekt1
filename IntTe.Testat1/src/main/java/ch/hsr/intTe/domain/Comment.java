package ch.hsr.intTe.domain;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable, Votable{
	private static final long serialVersionUID = -4272793839234627484L;
	
	private String text;
	private Date date;
	private Post post;
	private int votes;

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

	@Override
	public int getVotes() {
		return votes;
	}

	@Override
	public int voteUp() {
		return this.votes++;
	}

	@Override
	public int voteDown() {
		return this.votes--;
	}
	
}
