package ch.hsr.intTe.dao;

import java.util.ArrayList;
import java.util.Date;

import com.google.common.base.Preconditions;

import ch.hsr.intTe.domain.Post;

public class PostDao {
	
	private static PostDao instance = new PostDao();
	
	private ArrayList<Post> posts = new ArrayList<Post>();
	
	public PostDao() {
		posts.add(createPost("Erster Post", "http://info.cern.ch/hypertext/WWW/TheProject.html", 
				new Date(), "Andreas"));
		posts.add(createPost("9gag", "http://9gag.com/"
				, new Date(), "Andreas"));
		posts.add(createPost("SE2 Projekt 13 Präsentationsplan", "http://wiki.hsr.ch/SE2Projekt/files/SE2P-Praesentationen-FS2013.pdf"
				, new Date(), "Andreas"));
	}
	
	public static synchronized PostDao getInstance(){
		return instance;
	}
	
	public Post savePost(Post post){
		Preconditions.checkNotNull(post);
		Preconditions.checkNotNull(post.getTitle(), "a post must have a title");
		Preconditions.checkNotNull(post.getLink(), "a post must have a link");
		posts.add(0, post);
		return post;
	}
	
	public Iterable<Post> getPosts(){
		return posts;
	}
	
	private static Post createPost(String title, String link, Date postedAt, String name){
		Post post = new Post();
		post.setTitle(title);
		post.setLink(link);
		post.setPostedAt(postedAt);
		post.setAuthor(name);
		return post;
	}

}
