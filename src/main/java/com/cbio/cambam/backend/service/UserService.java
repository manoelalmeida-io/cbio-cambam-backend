package com.cbio.cambam.backend.service;

import com.cbio.cambam.backend.exception.ResourceNotFoundException;
import com.cbio.cambam.backend.model.User;
import com.cbio.cambam.backend.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private final UserRepository repository;

	public UserService(UserRepository repository) {
		this.repository = repository;
	}
	
	public List<User> all() {
		return repository.findAll();
	}
	
	public Optional<User> one(String id) {
		return repository.findById(id);
	}
	
	public User create(User user) {
		String key = KeyGenerators.string().generateKey();
		user.setId(key);
		
		return repository.save(user);
	}
	
	public User update(String id, User user) {
		Optional<User> existent = repository.findById(id);
		
		if (existent.isPresent()) {
			user.setId(existent.get().getId());
			return repository.save(user);
		}
		
		throw new ResourceNotFoundException();
	}
	
	public void delete(String id) {
		Optional<User> user = repository.findById(id);
		
		user.ifPresentOrElse(repository::delete, () -> {
			throw new ResourceNotFoundException();
		});
	}
}
