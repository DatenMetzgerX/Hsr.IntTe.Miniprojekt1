package ch.hsr.intTe.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post implements Serializable, Votable {
	private static final long serialVersionUID = 4534629547661798393L;
	
	private String title;
	private String link;
	private Date postedAt;
	private String author;
	private int votes;
	private boolean commentsAreVisible = false;
	
	private List<Comment> comments = new ArrayList<>();
	
	public void addComment(Comment comment) {
		comments.add(comment);
	}
	
	public Iterable<Comment> getComments() {
		return comments;
	}
	
	public void removeComment(Comment comment) {
		comments.remove(comment);
	}
	
	public int getNumberOfComments() {
		return comments.size();
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
	
	public boolean getCommentsAreVisible() {
		return commentsAreVisible;
	}

	public void setCommentsAreVisible(boolean commentsAreVisible) {
		this.commentsAreVisible = commentsAreVisible;
	}
	
	public void togleCommentsAreVisible() {
		System.out.println(comments.size());
		if(comments.size() > 0){
			this.commentsAreVisible = !this.commentsAreVisible;
		}
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
