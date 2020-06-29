package com.cbio.kanban.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_column")
public class Column implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Integer position;
	
	@ManyToOne
	@JoinColumn(name = "kanban")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Kanban kanban;
	
	@OneToMany(mappedBy = "kanbanColumn")
	private List<Task> tasks = new ArrayList<>();
}
