package org.springframework.samples.escalade.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SaveAppUserDao  {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	public void createUserAccount(Integer user_id, String userName, String password, boolean enabled) {
    	try {
    		
    		encrytePassword(password);
    		//INSERT INTO public.app_user (user_id, user_name, encryted_password, enabled) VALUES(3, 'dbuser2', '123', '1');
    		String INSERT_SQL = "INSERT INTO AppUser (user_id, user_name,encryted_password, enabled) VALUES(?, ?, ?, ?)";
    		entityManager.createNativeQuery(INSERT_SQL).setParameter(userName, password).executeUpdate();
    		    		
    		
    	} catch (NoResultException e) {
    	
    }
		
    }
	
	private String encrytePassword(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
		
	}
	
}
