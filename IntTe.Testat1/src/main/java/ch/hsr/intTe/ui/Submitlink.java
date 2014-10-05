package ch.hsr.intTe.ui;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import ch.hsr.intTe.dao.PostDao;
import ch.hsr.intTe.domain.Post;
import ch.hsr.intTe.domain.User;

@ManagedBean
@RequestScoped
public class Submitlink {
	
	private String title;
	private String link;
	
	public String submit(){
		PostDao postDao = PostDao.getInstance();
		
		Post post = new Post();
		post.setAuthor(currentUserName());
		post.setTitle(title);
		post.setLink(compleatLink(link));
		post.setPostedAt(new Date());
		postDao.savePost(post);
		
		return "/index.xhtml";
	}
	
	private String currentUserName(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);

		User user = (User) session.getAttribute("user");
		
		if(user != null){
			return user.getUsername();
		}
		return "anonymous";
	}
	
	private String compleatLink(String link){
		if(link.substring(0, 3).equals("http")){
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

}
