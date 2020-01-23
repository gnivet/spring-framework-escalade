package org.springframework.samples.escalade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.samples.escalade.model.Role;



public interface RoleRepository extends JpaRepository<Role, Integer>{
}
