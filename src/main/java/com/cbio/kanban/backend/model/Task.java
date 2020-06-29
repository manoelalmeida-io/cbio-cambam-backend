package com.cbio.kanban.backend.model;

import java.io.Serializable;
import java.time.OffsetDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_task")
public class Task implements Serializable {

	@Id
	private String id;
	private String title;
	private String description;
	private OffsetDateTime creationDate;
	private OffsetDateTime dueDate;
	private OffsetDateTime endDate;
	
	@ManyToOne
	@JoinColumn(name = "kanban_column")
	private Column kanbanColumn;
}
