package org.springframework.samples.escalade.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Point;

public class JpaPointRepositoryImpl {

	

		@PersistenceContext
		private EntityManager em;

		public Point findPointById(Integer id) {
			return this.em.find(Point.class, id);
		}

		// Add Way to Site form
		public void savePoint(Point Point) throws DataAccessException {
			if (Point.getId() == null) {
				this.em.persist(Point);
			} else {
				this.em.merge(Point);
			}

		}
	
}
