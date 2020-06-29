package com.cbio.kanban.backend.controller;

import com.cbio.kanban.backend.model.Column;
import com.cbio.kanban.backend.model.Kanban;
import com.cbio.kanban.backend.service.KanbanService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kanbans/{kanbanId}/columns")
public class KanbanColumnController {

	private final KanbanService service;

	public KanbanColumnController(KanbanService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<Column>> list(@PathVariable String kanbanId) {
		Kanban kanban = service.one(kanbanId);
		return ResponseEntity.ok(kanban.getColumns());
	}
}
