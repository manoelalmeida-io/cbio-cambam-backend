package com.cbio.kanban.backend.model;

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
@Table(name = "tb_kanban")
public class Kanban {

	@Id
	private String id;
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "owner")
	private User owner;
}
