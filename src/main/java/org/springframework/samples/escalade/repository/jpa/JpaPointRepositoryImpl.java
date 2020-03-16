package org.springframework.samples.escalade.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Point;
import org.springframework.samples.escalade.repository.PointRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class JpaPointRepositoryImpl implements PointRepository{

	

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

		@Override
		public Point findById(Integer id) throws DataAccessException {
			// TODO Auto-generated method stub
			return null;
		}
	
}
