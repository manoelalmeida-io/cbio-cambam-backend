package com.cbio.kanban.backend.repository;

import com.cbio.kanban.backend.model.Column;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColumnRepository extends JpaRepository<Column, Long> {

}
