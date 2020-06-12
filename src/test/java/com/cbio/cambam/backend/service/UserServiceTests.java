package com.cbio.cambam.backend.service;

import com.cbio.cambam.backend.exception.ResourceNotFoundException;
import com.cbio.cambam.backend.model.User;
import com.cbio.cambam.backend.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;

public class UserServiceTests {

	private final UserRepository repository = Mockito.mock(UserRepository.class);
	private UserService service;
	private User user;
	
	@BeforeEach
	void init() {
		service = new UserService(repository);
		user = new User(
				"912ec803b2ce49ee",
				"John Doe",
				"john.doe@mailserver.com",
				"1234",
				"johndoe"
		);
	}
	
	@Test
	void all() {
		List<User> all = List.of(user);
		when(repository.findAll()).thenReturn(all);
		
		List<User> users = service.all();
		assertThat(users).isEqualTo(all);
	}
	
	@Test
	void one() {
		when(repository.findById("912ec803b2ce49ee")).thenReturn(Optional.of(user));
		
		Optional<User> exists = service.one("912ec803b2ce49ee");
		assertThat(exists.get()).isEqualTo(user);
	}
	
	@Test
	void create() {
		when(repository.save(any(User.class))).then(returnsFirstArg());
		
		User created = service.create(user);
		assertThat(created).isEqualTo(user);
	}
	
	@Test
	void update() {
		when(repository.findById("912ec803b2ce49ee")).thenReturn(Optional.of(user));
		when(repository.save(any(User.class))).then(returnsFirstArg());
		
		User toUpdate = user;
		toUpdate.setId("");
		toUpdate.setGithubUsername("johndoe823");
		
		User updated = service.update("912ec803b2ce49ee", toUpdate);
		assertThat(updated).isEqualTo(toUpdate);
		assertThrows(ResourceNotFoundException.class, () -> service.update("63d0cea9d550e49s", toUpdate));
	}
	
	@Test
	void delete() {
		when(repository.findById("912ec803b2ce49ee")).thenReturn(Optional.of(user));
		
		assertDoesNotThrow(() -> service.delete("912ec803b2ce49ee"));
		assertThrows(ResourceNotFoundException.class, () -> service.delete("63d0cea9d550e49s"));
	}
}
