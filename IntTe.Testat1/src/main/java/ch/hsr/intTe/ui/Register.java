package ch.hsr.intTe.ui;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import ch.hsr.intTe.ServiceLocator;
import ch.hsr.intTe.domain.User;
import ch.hsr.intTe.service.UserService;
import ch.hsr.intTe.ui.validation.UserDoesntExist;

@ManagedBean
@RequestScoped
public class Register implements Serializable {
	private static final long serialVersionUID = -2948986133701289370L;

	@NotNull
	@Length(min=3, max=15)
	@UserDoesntExist(message="Ein Benutzer mit diesem Login existiert bereits.")
	private String username;
	
	@NotNull
	@Length(min=3, max=128)
	private String password;
	
	@NotNull
	@Length(min=3, max=128)
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
