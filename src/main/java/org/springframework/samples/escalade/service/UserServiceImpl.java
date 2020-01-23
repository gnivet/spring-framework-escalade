package org.springframework.samples.escalade.service;

public interface UserServiceImpl  {

	 String findLoggedInusername();

	    void autoLogin(String username, String password);
	
}