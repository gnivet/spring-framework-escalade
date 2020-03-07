package org.springframework.samples.escalade.service;

import org.springframework.samples.escalade.model.User;

public interface UserService {
    

    User findByUsername(String username);

	void save(User user);

	void save(org.springframework.security.core.userdetails.User user);

	
    
    
}