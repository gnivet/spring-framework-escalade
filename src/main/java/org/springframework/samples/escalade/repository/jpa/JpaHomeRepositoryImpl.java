package org.springframework.samples.escalade.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.AppUser;
import org.springframework.samples.escalade.repository.HomeRepository;
import org.springframework.stereotype.Repository;

@Repository
public class JpaHomeRepositoryImpl implements HomeRepository{

	@PersistenceContext
	private EntityManager em;

	
	public AppUser selectAppUserByUsername(long id) throws DataAccessException {
		Query query = this.em.createQuery("select appuser from AppUser appuser where user.userName = ?");
		query.setParameter("id", id);
		return (AppUser) query.getSingleResult();
	}

	
	
	
	
	
	
	@Override
	public void saveAppUser(AppUser appuser ) throws DataAccessException {
		// TODO Auto-generated method stub
		
		if (appuser.getUserId() == null) {
			 //Object bCryptPasswordEncoder;
			String encrytedPassword = null;
			appuser.setEncrytedPassword(encrytedPassword);
			this.em.persist(appuser);
		} else {
			this.em.merge(appuser);
		}
		
	}	
	
}
