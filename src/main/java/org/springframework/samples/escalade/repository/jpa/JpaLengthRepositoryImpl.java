package org.springframework.samples.escalade.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Length;

public class JpaLengthRepositoryImpl {

	
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
	}

