package ch.hsr.intTe.dao;

import java.util.ArrayList;
import java.util.Collection;

import ch.hsr.intTe.domain.User;

import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class UserDao {
	
	private static UserDao instance = new UserDao();
	
	private Collection<User> users = new ArrayList<>();
	
	public static synchronized UserDao getInstance() {
		return instance;
	}
	
	public UserDao() {
		users.add(createUser("micha", "welcome"));
		users.add(createUser("andreas", "welcome"));
	}
	
	public Iterable<User> readAll() {
		return users;
	}
	
	public Optional<User> findByUsername(String username) {
		Preconditions.checkNotNull(username);
		User user = Iterables.find(users, createFindByUsernamePredicate(username), null);
		return Optional.fromNullable(user);
	}
	
	public User save(User user) {
		Preconditions.checkNotNull(user);
		Preconditions.checkNotNull(user.getUsername(), "The user needs a username");
		Preconditions.checkArgument(!findByUsername(user.getUsername()).isPresent(), "a user with the same username already exists.");
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
	
	private static User createUser(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		return user;
	}

}
