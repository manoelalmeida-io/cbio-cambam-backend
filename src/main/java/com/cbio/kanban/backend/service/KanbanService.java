package com.cbio.kanban.backend.service;

import com.cbio.kanban.backend.exception.ResourceNotFoundException;
import com.cbio.kanban.backend.model.Kanban;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.cbio.kanban.backend.repository.KanbanRepository;

@Service
public class KanbanService {

	private final KanbanRepository repository;

	public KanbanService(KanbanRepository repository) {
		this.repository = repository;
	}
	
	public List<Kanban> all() {
		return repository.findAll();
	}
	
	public Optional<Kanban> one(String id) {
		return repository.findById(id);
	}
	
	public Kanban create(Kanban cambam) {
		return repository.save(cambam);
	}
	
	public Kanban update(String id, Kanban cambam) {
		Optional<Kanban> existent = repository.findById(id);
		
		if (existent.isPresent()) {
			cambam.setId(existent.get().getId());
			return repository.save(cambam);
		}
		
		throw new ResourceNotFoundException();
	}
	
	public void delete(String id) {
		Optional<Kanban> cambam = repository.findById(id);
		
		cambam.ifPresentOrElse(repository::delete, () -> {
			throw new ResourceNotFoundException();
		});
	}
}
