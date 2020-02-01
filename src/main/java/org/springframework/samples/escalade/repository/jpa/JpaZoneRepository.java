package org.springframework.samples.escalade.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Zone;

public class JpaZoneRepository {

	@PersistenceContext
	private EntityManager em;

	public Zone findZoneById(Integer id) {
		return this.em.find(Zone.class, id);
	}

	// Add Zone to Site form
	public void saveZone(Zone Zone) throws DataAccessException {
		if (Zone.getId() == null) {
			this.em.persist(Zone);
		} else {
			this.em.merge(Zone);
		}

	}

}
