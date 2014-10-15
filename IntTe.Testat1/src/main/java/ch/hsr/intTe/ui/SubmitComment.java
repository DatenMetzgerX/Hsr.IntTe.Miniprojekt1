package ch.hsr.intTe.ui;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.hibernate.validator.constraints.NotEmpty;

import ch.hsr.intTe.ServiceLocator;
import ch.hsr.intTe.domain.Comment;
import ch.hsr.intTe.domain.Post;
import ch.hsr.intTe.service.PostService;

@ManagedBean
@RequestScoped
public class SubmitComment {
	
	@NotEmpty
	private String text;

	public void submitComment(Post post){
		Comment comment = new Comment();
		comment.setText(text);
		comment.setDate(new Date());
		
		System.out.println(post.getTitle());
		
		PostService postService = ServiceLocator.getInstance().locate(PostService.class);
		postService.addComment(post, comment);
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
