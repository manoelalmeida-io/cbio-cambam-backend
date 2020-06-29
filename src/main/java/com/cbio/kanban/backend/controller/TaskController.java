package com.cbio.kanban.backend.controller;

import com.cbio.kanban.backend.model.Task;
import com.cbio.kanban.backend.service.TaskService;
import java.util.List;
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
@RequestMapping("/api/tasks")
public class TaskController {

	private final TaskService service;

	public TaskController(TaskService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<Task>> all() {
		List<Task> tasks = service.all();
		return ResponseEntity.ok(tasks);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Task> find(@PathVariable String id) {
		Task task = service.find(id);
		return ResponseEntity.ok(task);
	}
	
	@PostMapping
	public ResponseEntity<Task> create(@RequestBody Task task) {
		Task created = service.create(task);
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Task> update(@PathVariable String id, @RequestBody Task task) {
		Task updated = service.update(id, task);
		return ResponseEntity.ok(updated);
	}
	
	@DeleteMapping("/id")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
