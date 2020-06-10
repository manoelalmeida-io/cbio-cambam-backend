package com.cbio.cambam.backend.controller;

import com.cbio.cambam.backend.exception.ResourceNotFoundException;
import com.cbio.cambam.backend.model.User;
import com.cbio.cambam.backend.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final UserService service;

	public UserController(UserService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<User>> all() {
		List<User> users = service.all();
		return ResponseEntity.ok(users);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> one(@PathVariable String id) {
		Optional<User> user = service.one(id);
		
		if (user.isPresent()) {
			return ResponseEntity.ok(user.get());
		}
		
		throw new ResourceNotFoundException();
	}
	
	@PostMapping
	public ResponseEntity<User> create(@RequestBody User user) {
		User created = service.create(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable String id, @RequestBody User user) {
		User updated = service.update(id, user);
		return ResponseEntity.ok(updated);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
