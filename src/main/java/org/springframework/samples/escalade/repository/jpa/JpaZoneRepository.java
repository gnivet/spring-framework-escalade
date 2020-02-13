package org.springframework.samples.escalade.repository.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Zone;
import org.springframework.samples.escalade.repository.ZoneRepository;
import org.springframework.stereotype.Repository;

@Repository
public class JpaZoneRepository implements ZoneRepository{

	@PersistenceContext
	private EntityManager em;

	public Zone findZoneById(Integer id) {
				
		Query query = this.em.createQuery("SELECT zone FROM Zone zone WHERE zone.id =:id");
		query.setParameter("id", id);
		return (Zone) query.getSingleResult();
					
	}

	// Add Zone to Site form
	public void saveZone(Zone Zone) throws DataAccessException {
		if (Zone.getId() == null) {
			this.em.persist(Zone);
		} else {
			this.em.merge(Zone);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Zone> findZoneByName(String name) throws DataAccessException {
		// TODO Auto-generated method stub

    	Query query = this.em.createQuery("SELECT DISTINCT zone from Zone zone WHERE zone.name LIKE :name");
		 query.setParameter("name", name + "%");
		 return query.getResultList();
	}

}
