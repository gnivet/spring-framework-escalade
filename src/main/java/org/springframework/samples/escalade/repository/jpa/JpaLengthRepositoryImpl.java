package org.springframework.samples.escalade.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Length;
import org.springframework.samples.escalade.repository.LengthRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class JpaLengthRepositoryImpl implements LengthRepository{

	
		@PersistenceContext
		private EntityManager em;

		public Length findLengthById(Integer id) {
			return this.em.find(Length.class, id);
		}

		// Add Way to Site form
		public void saveLength(Length Length) throws DataAccessException {
			if (Length.getId() == null) {
				this.em.persist(Length);
			} else {
				this.em.merge(Length);
			}

		}

		@Override
		public Length findById(Integer id) {
			// TODO Auto-generated method stub
			return null;
		}
	}

