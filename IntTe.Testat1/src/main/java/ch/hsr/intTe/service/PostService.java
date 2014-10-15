package ch.hsr.intTe.service;

import ch.hsr.intTe.ServiceLocator;
import ch.hsr.intTe.dao.PostDao;
import ch.hsr.intTe.domain.Comment;
import ch.hsr.intTe.domain.Post;

public class PostService {

	private final PostDao postDao;
	
	public PostService() {
		postDao = ServiceLocator.getInstance().locate(PostDao.class);
	}
	
	public Iterable<Post> getPosts(){
		return postDao.getPosts();
	}
	
	public Post savePost(Post post){
		return postDao.savePost(post);
	}
	
	public void addComment(Post post, Comment comment){
		postDao.addComment(post, comment);
	}
	
}
