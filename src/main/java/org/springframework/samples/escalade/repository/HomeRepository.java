package org.springframework.samples.escalade.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.AppUser;




public interface HomeRepository {

	
	
	static Collection<AppUser> findAppUserByLastName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	void saveAppUser(AppUser appuser) throws DataAccessException;

}
