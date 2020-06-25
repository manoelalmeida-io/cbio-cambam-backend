package com.cbio.kanban.backend.controller;

import com.cbio.kanban.backend.model.Column;
import com.cbio.kanban.backend.service.ColumnService;
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
@RequestMapping("/api/columns")
public class ColumnController {

	private final ColumnService service;

	public ColumnController(ColumnService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<Column>> all() {
		List<Column> columns = service.list();
		return ResponseEntity.ok(columns);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Column> find(@PathVariable Long id) {
		Column column = service.find(id);
		return ResponseEntity.ok(column);
	}
	
	@PostMapping
	public ResponseEntity<Column> create(@RequestBody Column column) {
		Column created = service.create(column);
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Column> update(@PathVariable Long id, @RequestBody Column column) {
		Column updated = service.update(id, column);
		return ResponseEntity.ok(updated);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
