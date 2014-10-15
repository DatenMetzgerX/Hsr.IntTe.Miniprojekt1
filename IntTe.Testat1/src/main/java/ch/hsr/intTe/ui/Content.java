package ch.hsr.intTe.ui;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ch.hsr.intTe.ServiceLocator;
import ch.hsr.intTe.domain.Post;
import ch.hsr.intTe.service.PostService;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

@ManagedBean
@ViewScoped
public class Content implements Serializable{
	private static final long serialVersionUID = 4713949485079134102L;
	
	private PostService postService = ServiceLocator.getInstance().locate(PostService.class);
	private List<Post> posts = null;
	
	public Iterable<Post> getPosts(){
		if (posts == null) {
			posts = Lists.newArrayList(postService.getPosts());
			posts.sort(Ordering.natural().reversed());
		}
		return posts;
	}
	
}
