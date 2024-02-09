package org.springframework.samples.escalade.service;

import org.springframework.samples.escalade.model.User;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);

	
}