package com.cbio.kanban.backend.controller;

import com.cbio.kanban.backend.exception.ResourceNotFoundException;
import com.cbio.kanban.backend.model.Kanban;
import com.cbio.kanban.backend.service.KanbanService;
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
@RequestMapping("/api/kanbans")
public class KanbanController {

	private final KanbanService service;

	public KanbanController(KanbanService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<Kanban>> all() {
		List<Kanban> kanbans = service.all();
		return ResponseEntity.ok(kanbans);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Kanban> one(@PathVariable String id) {
		Optional<Kanban> kanban = service.one(id);
		
		if (kanban.isPresent()) {
			return ResponseEntity.ok(kanban.get());
		}
		
		throw new ResourceNotFoundException();
	}
	
	@PostMapping
	public ResponseEntity<Kanban> create(@RequestBody Kanban kanban) {
		Kanban created = service.create(kanban);
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Kanban> update(@PathVariable String id, @RequestBody Kanban kanban) {
		Kanban updated = service.update(id, kanban);
		return ResponseEntity.ok(updated);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
