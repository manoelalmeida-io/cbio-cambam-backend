package com.cbio.kanban.backend.service;

import com.cbio.kanban.backend.exception.ResourceNotFoundException;
import com.cbio.kanban.backend.model.Column;
import com.cbio.kanban.backend.repository.ColumnRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ColumnService {

	private final ColumnRepository repository;

	public ColumnService(ColumnRepository repository) {
		this.repository = repository;
	}
	
	public List<Column> list() {
		return repository.findAll();
	}
	
	public Column find(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException());
	}
	
	public Column create(Column column) {
		return repository.save(column);
	}
	
	public Column update(Long id, Column column) {
		Column existent = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException());
		
		column.setId(existent.getId());
		return repository.save(column);
	}
	
	public void delete(Long id) {
		Optional<Column> column = repository.findById(id);
		
		column.ifPresentOrElse(repository::delete, () -> {
			throw new ResourceNotFoundException();
		});
	}
}
