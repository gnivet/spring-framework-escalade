package org.springframework.samples.escalade.repository.jpa;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.NamedEntity;
import org.springframework.samples.escalade.model.Zone;
import org.springframework.samples.escalade.repository.ZoneRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public class JpaZoneRepositoryImpl implements ZoneRepository{

	@PersistenceContext
	private EntityManager em;
	

	
	

	public Zone findZoneById(Integer id) {
				
		Query query = this.em.createQuery("SELECT zone FROM Zone zone WHERE zone.id =:id");
		query.setParameter("id", id);
		return (Zone) query.getSingleResult();
					
	}

	public Zone saveZone(Zone zone) throws DataAccessException {

		if (zone.getId() == null) {
			this.em.persist(zone);
		} else {
			this.em.merge(zone);
		}
		return zone;

	}

	public NamedEntity updateZone(Zone zone) {
		if(!this.em.contains(zone))
			this.em.merge(zone);
		return zone;
	}
	
	

	@SuppressWarnings("unchecked")
	@Transactional
		public Collection<Zone> findZoneByName(String name) throws DataAccessException {
		// TODO Auto-generated method stub

    	Query query = this.em.createQuery("SELECT DISTINCT zone from Zone zone WHERE zone.name LIKE :name");
		 query.setParameter("name", "%" + name + "%");
		 return query.getResultList();
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Zone> findAll()
	{
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("SELECT zone FROM Zone zone");
		return  query.getResultList();
	}
}