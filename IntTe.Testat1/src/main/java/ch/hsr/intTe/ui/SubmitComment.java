package ch.hsr.intTe.ui;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import ch.hsr.intTe.domain.Comment;
import ch.hsr.intTe.domain.Post;

@ManagedBean
@RequestScoped
public class SubmitComment {
	
	String text;

	public void submitComment(Post post){
		Comment comment = new Comment();
		comment.setText(text);
		comment.setDate(new Date());
		post.addComment(comment);
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
