package org.springframework.samples.escalade.service;

import org.springframework.samples.escalade.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
    
    
}
