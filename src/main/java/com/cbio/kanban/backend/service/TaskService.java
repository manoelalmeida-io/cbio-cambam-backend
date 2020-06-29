package com.cbio.kanban.backend.service;

import com.cbio.kanban.backend.exception.ResourceNotFoundException;
import com.cbio.kanban.backend.model.Task;
import com.cbio.kanban.backend.repository.TaskRepository;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

	private final TaskRepository repository;

	public TaskService(TaskRepository repository) {
		this.repository = repository;
	}
	
	public List<Task> all() {
		return repository.findAll();
	}
	
	public Task find(String id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException());
	}
	
	public Task create(Task task) {
		String key = KeyGenerators.string().generateKey();
		task.setId(key);
		task.setCreationDate(OffsetDateTime.now());
		
		return repository.save(task);
	}
	
	public Task update(String id, Task task) {
		Task existent = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException());
		
		task.setId(existent.getId());
		return repository.save(task);
	}
	
	public void delete(String id) {
		Optional<Task> task = repository.findById(id);
		
		task.ifPresentOrElse(repository::delete, () -> {
			throw new ResourceNotFoundException();
		});
	}
}
