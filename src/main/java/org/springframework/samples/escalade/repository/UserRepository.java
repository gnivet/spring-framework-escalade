package org.springframework.samples.escalade.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.escalade.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

	Collection<org.springframework.boot.autoconfigure.security.SecurityProperties.User> findUserById(Integer id);
	
	
}
