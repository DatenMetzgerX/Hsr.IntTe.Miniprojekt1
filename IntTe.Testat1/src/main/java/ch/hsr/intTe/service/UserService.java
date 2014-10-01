package ch.hsr.intTe.service;

import ch.hsr.intTe.ServiceLocator;
import ch.hsr.intTe.dao.UserDao;
import ch.hsr.intTe.domain.User;

public class UserService {
	
	private final UserDao userDao;
	
	public UserService() {
		userDao = ServiceLocator.getInstance().locate(UserDao.class);
	}
	
	public Iterable<User> getUsers() {
		return userDao.readAll();
	}
	
	public User getByUsername(String username) {
		return userDao.findByUsername(username);
	}

	public User save(User user) {
		return userDao.save(user);
	}
}
