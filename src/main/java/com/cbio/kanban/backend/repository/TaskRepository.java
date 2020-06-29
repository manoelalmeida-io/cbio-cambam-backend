package com.cbio.kanban.backend.repository;

import com.cbio.kanban.backend.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, String> {

}
