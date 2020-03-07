package org.springframework.samples.escalade.repository.jpa;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Area;
import org.springframework.samples.escalade.model.Length;
import org.springframework.samples.escalade.model.Point;
import org.springframework.samples.escalade.model.Site;
import org.springframework.samples.escalade.model.SiteType;
import org.springframework.samples.escalade.model.Way;
import org.springframework.samples.escalade.model.Zone;
import org.springframework.samples.escalade.repository.SiteRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA implementation of the {@link AreaRepository} interface.
 *
 * @author Guillaume Nivet
 * @since 3.12.2019
 */
@Repository
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


	
	public void saveWay(Way way) throws DataAccessException {
		// TODO Auto-generated method stub

		if (way.getId() == null) {
			this.em.persist(way);
		} else {
			this.em.merge(way);
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



	public void saveSite(Site site) throws DataAccessException {
		// TODO Auto-generated method stub
		

		
			
			if (site.getId() == null) {
				this.em.persist(site);
			} else {
				this.em.merge(site);
			}
			
		
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


	
	public Area findAreaById(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("SELECT area FROM Area area WHERE area.id =:id");
		query.setParameter("id", id);
		return (Area) query.getSingleResult();
	}



	public void saveArea(Area area) throws DataAccessException {

		if (area.getId() == null) {
			this.em.persist(area);
		} else {
			this.em.merge(area);
		}
		
	}


	@SuppressWarnings("unchecked")
	public Collection<Area> findSiteByPostalCode(String postalcode) throws DataAccessException {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery(
				"SELECT DISTINCT area FROM Area area  left join fetch site.areas WHERE area.postalcode LIKE :postalcode");
		query.setParameter("postalcode", postalcode + "%");
		return query.getResultList();
	}
	
	
	
	
}
