package ch.hsr.intTe.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Post implements Serializable, Votable {
	private static final long serialVersionUID = 4534629547661798393L;
	
	private String title;
	private String link;
	private Date postedAt;
	private String author;
	private int votes;
	
	private ArrayList<Comment> comments = new ArrayList<>();
	
	public boolean addComment(Comment comment) {
		return comments.add(comment);
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getLink() {
		return link;
	}
	
	public void setLink(String link) {
		this.link = link;
	}

	public Date getPostedAt() {
		return postedAt;
	}

	public void setPostedAt(Date postedAt) {
		this.postedAt = postedAt;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public int voteUp() {
		return this.votes++;
	}
	
	@Override
	public int getVotes() {
		return votes;
	}

	@Override
	public int voteDown() {
		return this.votes--;
	}
	
}
