package com.cbio.kanban.backend.repository;

import com.cbio.kanban.backend.model.Kanban;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KanbanRepository extends JpaRepository<Kanban, String> {
	
}
