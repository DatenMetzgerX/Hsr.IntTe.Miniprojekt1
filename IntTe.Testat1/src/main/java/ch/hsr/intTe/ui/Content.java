package ch.hsr.intTe.ui;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import ch.hsr.intTe.ServiceLocator;
import ch.hsr.intTe.domain.Post;
import ch.hsr.intTe.service.PostService;

@ManagedBean
@ApplicationScoped
public class Content implements Serializable{
	private static final long serialVersionUID = 4713949485079134102L;
	
	private PostService postService = ServiceLocator.getInstance().locate(PostService.class);
	
	public Iterable<Post> getPosts(){
		return postService.getPosts();
	}
	
}
