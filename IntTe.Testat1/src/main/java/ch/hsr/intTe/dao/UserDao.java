package ch.hsr.intTe.dao;

import java.util.ArrayList;
import java.util.Collection;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

import ch.hsr.intTe.domain.User;

public class UserDao {
	
	private static UserDao instance = new UserDao();
	
	private Collection<User> users = new ArrayList<>();
	
	public static synchronized UserDao getInstance() {
		return instance;
	}
	
	public Iterable<User> readAll() {
		return users;
	}
	
	public User findByUsername(String username) {
		Preconditions.checkNotNull(username);
		return Iterables.find(users, createFindByUsernamePredicate(username), null);
	}
	
	public User save(User user) {
		Preconditions.checkNotNull(user);
		this.users.add(user);
		return user;
	}
	
	private static Predicate<User> createFindByUsernamePredicate(String username) {
		final String lowercaseUsername = username.toLowerCase();
		return new Predicate<User>() {

			@Override
			public boolean apply(User user) {
				return Objects.equal(user.getUsername().toLowerCase(), lowercaseUsername);
			}
		};
	}

}
