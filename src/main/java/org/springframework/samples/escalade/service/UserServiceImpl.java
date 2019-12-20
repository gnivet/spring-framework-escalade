package org.springframework.samples.escalade.service;

public interface UserServiceImpl  {

	 String findLoggedInUsername();

	    void autoLogin(String username, String password);
	
}
