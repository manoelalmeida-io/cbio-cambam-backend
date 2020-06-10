package com.cbio.cambam.backend.repository;

import com.cbio.cambam.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
