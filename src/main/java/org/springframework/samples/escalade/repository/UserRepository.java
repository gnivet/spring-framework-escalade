package org.springframework.samples.escalade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.escalade.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

	User findById(int userId);
}


