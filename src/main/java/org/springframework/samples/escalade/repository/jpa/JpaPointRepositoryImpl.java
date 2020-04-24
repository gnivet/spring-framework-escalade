package org.springframework.samples.escalade.repository.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
		public Point savePoint(Point Point) throws DataAccessException {
			if (Point.getId() == null) {
				this.em.persist(Point);
			} else {
				this.em.merge(Point);
			}
			return Point;

		}

		@Override
		public Point findById(Integer id) throws DataAccessException {
			// TODO Auto-generated method stub
			return null;
		}

		@SuppressWarnings("unchecked")
		@Transactional
		public Collection<Point> findPointByName(String name) {
			// TODO Auto-generated method stub

			Query query = this.em.createQuery("SELECT point from Point point WHERE point.name like :name");
			query.setParameter("name", "%" + name + "%");
			return  query.getResultList();
		}
	
		
		
		
}
