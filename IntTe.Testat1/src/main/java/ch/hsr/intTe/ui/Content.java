package ch.hsr.intTe.ui;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import ch.hsr.intTe.dao.PostDao;
import ch.hsr.intTe.domain.Post;

@ManagedBean
@ApplicationScoped
public class Content implements Serializable{
	private static final long serialVersionUID = 4713949485079134102L;
	
	private PostDao postDao = PostDao.getInstance();
	
	public Iterable<Post> getPosts(){
		return postDao.getPosts();
	}
	
}
