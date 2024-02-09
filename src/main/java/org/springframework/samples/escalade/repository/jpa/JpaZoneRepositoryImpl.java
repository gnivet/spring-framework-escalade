package org.springframework.samples.escalade.repository.jpa;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Comment;
import org.springframework.samples.escalade.model.NamedEntity;
import org.springframework.samples.escalade.model.Zone;
import org.springframework.samples.escalade.repository.ZoneRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class JpaZoneRepositoryImpl implements ZoneRepository {

	@PersistenceContext
	private EntityManager em;
	private Session session;

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
		if (!this.em.contains(zone))
			this.em.merge(zone);
		return zone;
	}

	@SuppressWarnings("unchecked")
	public Collection<Zone> findZones(String name) throws DataAccessException {
		name = "Zone A";
		Query query = this.em.createQuery("SELECT DISTINCT name FROM Zone zone WHERE zone.name like :name");
		query.setParameter("name", "%" + name + "%");
		return query.getResultList();
	}

	
	@SuppressWarnings("unchecked")
	@Transactional
	public Collection<Zone> findZoneByName(String name) throws DataAccessException {
		
		// TODO Auto-generated method stub
		// Query query = this.em.createQuery("SELECT DISTINCT comment from Comment
		// comment WHERE comment.name LIKE :name");
		//Query query = this.em.createQuery("SELECT distinct site FROM User user join Site site on site.user.id = user.id join Zone zone on zone.site.id = site.id where site.name like :name")
		//Query query = this.em.createQuery("SELECT DISTINCT user FROM User user left join fetch user.sites WHERE user.userName LIKE :userName");
		//Query query = this.em.createQuery("SELECT DISTINCT site FROM Zone zone join Site site on zone.site.id = site.id WHERE zone.site.name LIKE :name");
		//Query query = this.em.createQuery("select zones.name from zones join users on zones.user_id = users.id join sites on sites.id = zones.site_id where zones.name like :name");
		Query query = this.em.createQuery("select distinct zone.name from Zone zone join User user on zone.user_id = user.id join Site site on site.id = zone.site_id where zone.name like :name");
		//Query query = this.em.createQuery("SELECT DISTINCT zone.name from Zone zone JOIN Site site on site.id = zone.id WHERE zone.name LIKE :name");
		query.setParameter("name", "%" + name + "%");
	
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Zone> findAll() {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("SELECT zone FROM Zone zone");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Collection<Zone> findZoneBySiteName(String name) throws DataAccessException {
		// TODO Auto-generated method stub

		Query query = this.em.createQuery(
				"SELECT distinct zone.name, way.name FROM Site site left join Zone zone on zone.id = site.id join Way way on way.id = site.id where site.name like :name");
		query.setParameter("name", "%" + name + "%");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Zone> findZones() throws DataAccessException {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("SELECT zone FROM Zone zone");
		return query.getResultList();
	}

	@Override
	public Collection<Zone> findZoneByNames(String name) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Zone> findZoneByNames() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}