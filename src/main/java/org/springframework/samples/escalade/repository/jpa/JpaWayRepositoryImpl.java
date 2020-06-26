package org.springframework.samples.escalade.repository.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Way;
import org.springframework.samples.escalade.repository.WayRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class JpaWayRepositoryImpl implements WayRepository{

	

		@PersistenceContext
		private EntityManager em;

		public Way findWayById(Integer id) {
			return this.em.find(Way.class, id);
		}

		
		public Way findById(Integer id) throws DataAccessException {
			// TODO Auto-generated method stub

			Query query = this.em.createQuery("SELECT way FROM Way way WHERE way.id =:id");
			query.setParameter("id", id);
			return (Way) query.getSingleResult();
		}
		
		
		
		
		
		
		// Add Way to Site form
		public Way saveWay(Way way) throws DataAccessException {
			if (way.getId() == null) {
				this.em.persist(way);
			} else {
				this.em.merge(way);
			}
			return way;

		}


		@SuppressWarnings("unchecked")
		public Collection<Way> findWayByName(String name) throws DataAccessException{
			// TODO Auto-generated method stub
			Query query = this.em.createQuery("SELECT DISTINCT way from Way way WHERE way.name like :name");
			query.setParameter("name", "%" + name + "%");
			return  query.getResultList();
		}
		
		

		
		
		
	
}
