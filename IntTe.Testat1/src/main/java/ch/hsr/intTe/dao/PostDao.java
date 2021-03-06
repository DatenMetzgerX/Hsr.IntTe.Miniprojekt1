package ch.hsr.intTe.dao;

import java.util.ArrayList;
import java.util.Date;

import com.google.common.base.Preconditions;

import ch.hsr.intTe.domain.Comment;
import ch.hsr.intTe.domain.Post;

public class PostDao {
	
	private static PostDao instance = new PostDao();
	
	private ArrayList<Post> posts = new ArrayList<Post>();
	
	public PostDao() {
		posts.add(createPost("Erster Post", "http://info.cern.ch/hypertext/WWW/TheProject.html", 
				new Date(), "andreas", "Kommentar 1", "Kommentar 2"));
		posts.add(createPost("9gag", "http://9gag.com/"
				, new Date(), "andreas"));
		posts.add(createPost("SE2 Projekt 13 Präsentationsplan", "http://wiki.hsr.ch/SE2Projekt/files/SE2P-Praesentationen-FS2013.pdf"
				, new Date(), "andreas"));
	}
	
	public static synchronized PostDao getInstance(){
		return instance;
	}
	
	public Post savePost(Post post){
		Preconditions.checkNotNull(post);
		Preconditions.checkNotNull(post.getTitle(), "a post must have a title");
		Preconditions.checkNotNull(post.getLink(), "a post must have a link");
		if(!posts.contains(post)){
			posts.add(post);
		}

		return post;
	}
	
	public Post addComment(Post post, Comment comment){
		Preconditions.checkNotNull(post);
		Preconditions.checkNotNull(comment);
		post.addComment(comment);
		savePost(post);
		return post;
	}
	
	public Iterable<Post> getPosts(){
		return posts;
	}
	
	private static Post createPost(String title, String link, Date postedAt, 
			String name, String... comments){
		Post post = new Post();
		post.setTitle(title);
		post.setLink(link);
		post.setPostedAt(postedAt);
		post.setAuthor(name);
		
		for (String commentText : comments) {
			Comment comment = new Comment();
			comment.setText(commentText);
			comment.setDate(new Date());
			post.addComment(comment);
		}
		return post;
	}

}
