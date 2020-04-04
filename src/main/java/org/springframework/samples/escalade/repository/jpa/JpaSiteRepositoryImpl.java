package org.springframework.samples.escalade.repository.jpa;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Area;
import org.springframework.samples.escalade.model.Length;
import org.springframework.samples.escalade.model.NamedEntity;
import org.springframework.samples.escalade.model.Point;
import org.springframework.samples.escalade.model.Site;
import org.springframework.samples.escalade.model.SiteType;
import org.springframework.samples.escalade.model.Way;
import org.springframework.samples.escalade.model.Zone;
import org.springframework.samples.escalade.repository.AreaRepository;
import org.springframework.samples.escalade.repository.SiteRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * JPA implementation of the {@link AreaRepository} interface.
 *
 * @author Guillaume Nivet
 * @since 3.12.2019
 */
@Repository
@Transactional
public class JpaSiteRepositoryImpl implements SiteRepository {

	@PersistenceContext
	private EntityManager em;
	

	
	
	public void saveZone(Zone zone) throws DataAccessException {
		// TODO Auto-generated method stub

		if (zone.getId() == null) {
			this.em.persist(zone);
		} else {
			this.em.merge(zone);
		}
		
	}


	
	



	public void saveLength(Length length) throws DataAccessException {
		// TODO Auto-generated method stub
		

		if (length.getId() == null) {
			this.em.persist(length);
		} else {
			this.em.merge(length);
		}
		
	}


	
	public void savePoint(Point point) throws DataAccessException {
		// TODO Auto-generated method stub
		

		if (point.getId() == null) {
			this.em.persist(point);
		} else {
			this.em.merge(point);
		}
		
	}



	@SuppressWarnings("unchecked")
	public List<SiteType> findSiteTypes() throws DataAccessException {
		// TODO Auto-generated method stub
		//return (SiteType) query.getSingleResult();
			
		return this.em.createQuery("SELECT siteType FROM SiteType siteType ORDER BY siteType.name").getResultList();
		   
	}


	
	public Site findSiteById(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		
		Query query = this.em.createQuery("SELECT site FROM Site site WHERE site.id =:id");
		query.setParameter("id", id);
		return (Site) query.getSingleResult();
	}

	
public Site saveSite(Site site) throws DataAccessException {
				
		
		if (site.getId() == null) {
			this.em.persist(site);
		}
		
		else
		{
			this.em.merge(site);
		}
		return site;
	}



	
	

	
	
	
	
	



	public Zone findZoneById(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub

		Query query = this.em.createQuery("SELECT zone FROM Zone zone WHERE zone.id =:id");
		query.setParameter("id", id);
		return (Zone) query.getSingleResult();
	}


	public Way findWayById(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub

		Query query = this.em.createQuery("SELECT way FROM Way way WHERE way.id =:id");
		query.setParameter("id", id);
		return (Way) query.getSingleResult();
	}


	public Length findLengthById(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub

		Query query = this.em.createQuery("SELECT site FROM Length length WHERE length.id =:id");
		query.setParameter("id", id);
		return (Length) query.getSingleResult();
	}


	public Point findPointById(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("SELECT point FROM Point point WHERE point.id =:id");
		query.setParameter("id", id);
		return (Point) query.getSingleResult();
	}


	
	public NamedEntity findAreaById(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("SELECT area FROM Area area WHERE area.id =:id");
		query.setParameter("id", id);
		return (NamedEntity) query.getSingleResult();
	}



	public void saveArea(Area area) throws DataAccessException {

		if (area.getId() == null) {
			this.em.persist(area);
		} else {
			this.em.merge(area);
		}
		
	}

	public Way saveWay(Way way) throws DataAccessException {

		if (way.getId() == null) {
			this.em.persist(way);
		} else {
			this.em.merge(way);
		}
		return way;
		
	}
	

	@SuppressWarnings("unchecked")
	public Collection<Area> findSiteByPostalCode(String postalcode) throws DataAccessException {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery(
				"SELECT DISTINCT area FROM Area area WHERE area.postalcode LIKE :postalcode");
		query.setParameter("postalcode", postalcode + "%");
		return query.getResultList();
	}
	
	


	
	









	public Integer findSiteOwnedbyUser(String userName, Integer siteId)  throws DataAccessException {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("SELECT site FROM Site site  left join  User user on user.username like :userName");
		query.setParameter("userName", userName );
		query.setParameter("siteId", siteId );
		return siteId;	
	}


	@SuppressWarnings("unchecked")
	public List<Site> findAllSite() {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("SELECT site FROM Site site");
		return query.getResultList();
	}


	




	@Override
	public List<Site> findSite() throws DataAccessException {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("SELECT site FROM Site site");
		return query.getResultList();
	}










	













	


	
	
}
