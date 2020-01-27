package org.springframework.samples.escalade.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Way;

public class JpaWayRepositoryImpl {

	public class JpaWayRepository {

		@PersistenceContext
		private EntityManager em;

		public Way findWayById(long id) {
			return this.em.find(Way.class, id);
		}

		// Add Way to Site form
		public void saveWay(Way Way) throws DataAccessException {
			if (Way.getId() == null) {
				this.em.persist(Way);
			} else {
				this.em.merge(Way);
			}

		}
	}
}
