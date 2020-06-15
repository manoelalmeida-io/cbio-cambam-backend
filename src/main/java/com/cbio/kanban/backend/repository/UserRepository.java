package com.cbio.kanban.backend.repository;

import com.cbio.kanban.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
