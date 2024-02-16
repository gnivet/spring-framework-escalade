package org.springframework.samples.escalade.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);


}