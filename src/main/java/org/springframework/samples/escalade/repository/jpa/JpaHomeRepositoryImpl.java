package org.springframework.samples.escalade.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.User;
import org.springframework.samples.escalade.repository.HomeRepository;
import org.springframework.stereotype.Repository;

@Repository
public class JpaHomeRepositoryImpl implements HomeRepository{

	@PersistenceContext
	private EntityManager em;

	
	public User selectUserByUsername(long id) throws DataAccessException {
		Query query = this.em.createQuery("select user from User user where user.userName = ?");
		query.setParameter("id", id);
		return (User) query.getSingleResult();
	}

	
	
	
	
	
	
	@Override
	public void saveUser(User user ) throws DataAccessException {
		// TODO Auto-generated method stub
		
		if (user.getUserId() == null) {
			 //Object bCryptPasswordEncoder;
			String encrytedPassword = null;
			user.setEncrytedPassword(encrytedPassword);
			this.em.persist(user);
		} else {
			this.em.merge(user);
		}
		
	}	
	
}
