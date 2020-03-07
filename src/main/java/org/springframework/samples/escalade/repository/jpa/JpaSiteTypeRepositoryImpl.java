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
		//return (SiteType) query.getSingleResult();
			
		return this.em.createQuery("SELECT siteType FROM SiteType siteType ORDER BY siteType.name").getResultList();
		   
	}	
	
	public SiteType findById(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		
		Query query = this.em.createQuery("SELECT siteType FROM SiteType siteType WHERE site.id =:id");
		query.setParameter("id", id);
		return (SiteType) query.getSingleResult();
	}



	public SiteType saveSiteType(SiteType siteType) throws DataAccessException {
		// TODO Auto-generated method stub
		

		
			
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

	

	@Override
	public SiteType findById(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.em.find(SiteType.class, id);
	}

	@Override
	public SiteType findSiteTypeById(int siteTypeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
