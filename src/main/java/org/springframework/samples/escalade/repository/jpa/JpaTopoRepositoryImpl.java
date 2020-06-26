package org.springframework.samples.escalade.repository.jpa;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Topo;
import org.springframework.samples.escalade.repository.TopoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class JpaTopoRepositoryImpl implements TopoRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Topo findTopoById(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("SELECT topo FROM Topo topo WHERE topo.id =:id");
		query.setParameter("id", id);
		return (Topo) query.getSingleResult();
	}

	@Override
	public Topo saveTopo(Topo topo) throws DataAccessException {
		// TODO Auto-generated method stub
		if (topo.getId() == null) {
			this.em.persist(topo);			
		} else {
			this.em.merge(topo);
		}
		return topo;
	}

	@Override
	public Topo updateTopo(Topo topo) {
		// TODO Auto-generated method stub
		if (!this.em.contains(topo))
			this.em.merge(topo);
		
		return topo;
	}
	
	
	@SuppressWarnings("unchecked")
	public Collection<Topo> findTopoByName(String name) {
		// TODO Auto-generated method stub

		Query query = this.em
				.createQuery("SELECT DISTINCT topo from Topo topo WHERE topo.name LIKE :name");
		query.setParameter("name", "%" + name + "%");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Topo> findTopoAvailableByName(String name) throws DataAccessException {
		// TODO Auto-generated method stub
		Query query = this.em
				.createQuery("SELECT DISTINCT topo from Topo topo WHERE topo.name LIKE :name and topo.available = true");
		query.setParameter("name", "%" + name + "%");
		
		return query.getResultList();
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Topo> findTopoByUserName(String userName) {
		// TODO Auto-generated method stub	
		
		Query query = this.em.createQuery("SELECT topo FROM Topo topo WHERE topo.user.username like :userName");
		
		query.setParameter("userName", "%" + userName + "%");		 
		return  query.getResultList();
	}
	

	

	

	

	@SuppressWarnings("unchecked")
	public List<Topo> getJoinInformation(String userName) {
		// TODO Auto-generated method stub
		
		Query query = this.em.createQuery("SELECT new TopoResponse(t.name, t.available, t.comment_date, t.description, u.first_name, u.last_name ) FROM Topo t JOIN u.username User u where u.username like: userName");
		{
				query.setParameter("userName", "%" + userName + "%");		 
		//return  query.getResultList();
		return query.getResultList() ;	}
				
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Topo> findTopoByUserId(Integer id) {
		// TODO Auto-generated method stub
	Query query = this.em.createQuery("SELECT topo FROM Topo topo WHERE user_id = :id");
		
		query.setParameter("id",  id );		 
		return  query.getResultList();
	}

	@Override
	public Topo findTopoByNames(String name) throws DataAccessException {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("SELECT topo FROM Topo topo WHERE topo.name like :name");
		query.setParameter("name", "%" + name + "%" );
		return (Topo) query.getResultList();
	}

	
	

	
	
	
	}

	
	

