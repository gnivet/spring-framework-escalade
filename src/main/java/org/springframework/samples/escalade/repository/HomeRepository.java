package org.springframework.samples.escalade.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.User;




public interface HomeRepository {

	
	
	static Collection<User> findUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	void saveUser(User user) throws DataAccessException;

}
