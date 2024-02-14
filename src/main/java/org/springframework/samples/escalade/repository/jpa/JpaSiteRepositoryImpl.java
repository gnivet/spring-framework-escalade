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

@Transactional
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

	
	@Transactional
	public Site findSiteById(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub

		Query query = this.em.createQuery("SELECT site FROM Site site WHERE site.id = :id");
		query.setParameter("id", id);
		return (Site) query.getSingleResult();
	}

	
	public Site saveSite(Site site) throws DataAccessException {

		if (site.getId() == null) {
			this.em.persist(site);
		}

		else {
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
		Query query = this.em.createQuery("SELECT DISTINCT area FROM Area area WHERE area.postalcode LIKE :postalcode");
		query.setParameter("postalcode", postalcode + "%");
		return query.getResultList();
	}

	public Integer findSiteOwnedbyUser(String userName, Integer siteId) throws DataAccessException {
		// TODO Auto-generated method stub
		Query query = this.em
				.createQuery("SELECT site FROM Site site  left join  User user on user.userName like :userName");
		query.setParameter("userName", userName);
		query.setParameter("siteId", siteId);
		return siteId;
	}

	@SuppressWarnings("unchecked")
	public List<Site> findAllSite() {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("SELECT site FROM Site site");
		return query.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Site> findSite() throws DataAccessException {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("SELECT site FROM Site site");
		return query.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public Collection<Site> findSiteByName(String name) {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("SELECT distinct site FROM Site site where site.name like :name");
		//Query query = this.em.createQuery("SELECT distinct site FROM User user join Site site on site.user.id = user.id join Zone zone on zone.site.id = site.id where site.name like :name");
		query.setParameter("name", "%" + name + "%");
		return query.getResultList();
	}

	
    public Integer findCommentBySite(String userName)throws DataAccessException {
		// TODO Auto-generated method stub
    	// select * from Sites join Users on sites.user_id = users.id where users.user_name like '%enora%';
		Query query = this.em.createQuery("select * from Site site join User user on site.user.id = user.id where user.userName like :userName");
		query.setParameter("userName", userName);	
		return   (Integer) query.getSingleResult();
	}
     
	//GN
	
	//@Override
	//public Collection<Site> findSiteByName1(String name) {
		// TODO Auto-generated method stub
	//	return null;
	//}

	@Override
	public Integer findSiteOwnedByUsername(String userName) throws DataAccessException {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("select count(*) from Site site join User user on site.user.id = user.id where user.userName like :userName");
		query.setParameter("userName", userName);	
		return   (Integer) query.getSingleResult();
	}

	@Override
	public Site findSiteByUsername(String userName) throws DataAccessException {
		// TODO Auto-generated method stub
				Query query = this.em
						.createQuery("SELECT site FROM Site site  left join  User user on user.userName like :userName");
				query.setParameter("userName", userName);
				return (Site) query.getSingleResult();
				
	}

	
	
	@Override
	public Site updateSite(Site site) throws DataAccessException {
		// TODO Auto-generated method stub
		if (!this.em.contains(site))
			this.em.merge(site);
		
		return site;
	}

	@Override
	public void site(Site site) {
		// TODO Auto-generated method stub
		if (site.getId() == null) {
			this.em.persist(site);
		} else {
			this.em.merge(site);
		}
	}

	@Override
	public List<Site> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<Site> listSites() {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("SELECT site FROM site site");

		return query.getResultList();
	}

}
