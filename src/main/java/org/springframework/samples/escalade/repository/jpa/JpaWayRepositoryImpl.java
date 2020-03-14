package org.springframework.samples.escalade.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.SiteType;
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
		public Way saveWay(Way Way) throws DataAccessException {
			if (Way.getId() == null) {
				this.em.persist(Way);
			} else {
				this.em.merge(Way);
			}
			return Way;

		}
		
		
		
		
		
	
}
