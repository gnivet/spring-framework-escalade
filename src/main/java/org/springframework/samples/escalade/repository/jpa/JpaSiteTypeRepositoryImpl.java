package org.springframework.samples.escalade.repository.jpa;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.SiteType;
import org.springframework.samples.escalade.repository.SiteTypeRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class JpaSiteTypeRepositoryImpl implements SiteTypeRepository {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<SiteType> findSiteTypes() throws DataAccessException {
		// TODO Auto-generated method stub
		// return (SiteType) query.getSingleResult();

		Query query = this.em.createQuery("SELECT siteType FROM SiteType siteType ORDER BY siteType.name");
		return query.getResultList();
				
		
	}
	
	 

	public SiteType findTypeById(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub

		Query query = this.em.createQuery("SELECT siteType FROM SiteType siteType WHERE siteType.id =:id");
		query.setParameter("id", id);
		return (SiteType) query.getSingleResult();
	}

	public SiteType saveSiteType(SiteType siteType) throws DataAccessException {

		if (siteType.getId() == null) {
			this.em.persist(siteType);
		} else {
			this.em.merge(siteType);
		}
		return siteType;		
	}

	public Collection<SiteType> findSiteBySiteType(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Transactional
	public SiteType findSiteTypeById(Integer id) {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("SELECT siteType FROM SiteType siteType WHERE siteType.id =:id");
		query.setParameter("id", id);
		return (SiteType) query.getSingleResult();
	}

	
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Collection<SiteType> findSiteTypeByName(String name) {
		// TODO Auto-generated method stub

		Query query = this.em.createQuery("select siteType from SiteType siteType WHERE siteType.name LIKE :name");
		query.setParameter("name", "%" + name + "%");
		return  query.getResultList();
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<SiteType> findAll() {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("SELECT siteType FROM SiteType siteType");
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Collection<SiteType> getSiteType() {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("SELECT siteType FROM SiteType siteType");
		return query.getResultList();
	}

}
