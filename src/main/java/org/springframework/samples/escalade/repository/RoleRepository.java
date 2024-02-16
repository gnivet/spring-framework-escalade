package org.springframework.samples.escalade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.escalade.model.Role;
import org.springframework.stereotype.Repository;
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{


}