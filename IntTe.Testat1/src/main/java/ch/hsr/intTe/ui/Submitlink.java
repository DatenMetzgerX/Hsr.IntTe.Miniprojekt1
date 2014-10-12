package ch.hsr.intTe.ui;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

import ch.hsr.intTe.ServiceLocator;
import ch.hsr.intTe.domain.Post;
import ch.hsr.intTe.domain.User;
import ch.hsr.intTe.service.PostService;

@ManagedBean
@RequestScoped
public class Submitlink {
	
	@ManagedProperty(value="#{login}")
	private Login login;
	
	@NotEmpty
	private String title;
	
	@NotEmpty
	@URL
	private String link;
	
	public String submit(){
		Post post = new Post();
		post.setAuthor(currentUserName());
		post.setTitle(title);
		post.setLink(compleatLink(link));
		post.setPostedAt(new Date());
		
		ServiceLocator.getInstance().locate(PostService.class).savePost(post);
		
		return "/index.xhtml";
	}
	
	private String currentUserName(){
		User user = login.getUser();
		
		if(user != null){
			return user.getUsername();
		}
		return "anonymous";
	}
	
	private String compleatLink(String link){
		if(link.length() > 3 && link.substring(0, 3).equals("http")){
			return link;
		}
		return "http://" + link;
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

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
}
