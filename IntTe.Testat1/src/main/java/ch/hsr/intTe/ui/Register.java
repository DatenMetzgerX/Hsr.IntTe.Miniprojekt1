package ch.hsr.intTe.ui;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import ch.hsr.intTe.ServiceLocator;
import ch.hsr.intTe.domain.User;
import ch.hsr.intTe.service.UserService;

@ManagedBean
@RequestScoped
public class Register {
	
	private String username;
	private String password;
	private String password2;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String register() {
		User user = new User();
		user.setUsername(username);;
		user.setPassword(password);
		
		ServiceLocator.getInstance().locate(UserService.class).save(user);
		return "/index.xhtml";
	}
}
