package org.springframework.samples.escalade.repository.jpa;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Area;
import org.springframework.samples.escalade.model.Length;
import org.springframework.samples.escalade.model.Point;
import org.springframework.samples.escalade.model.Site;
import org.springframework.samples.escalade.model.SiteType;
import org.springframework.samples.escalade.model.Way;
import org.springframework.samples.escalade.model.Zone;
import org.springframework.samples.escalade.repository.AreaRepository;
import org.springframework.samples.escalade.repository.SiteRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA implementation of the {@link AreaRepository} Integererface.
 *
 * @author Guillaume Nivet
 * @since 3.12.2019
 */
@Repository
public class JpaTopoRepositoryImpl implements SiteRepository {

	@PersistenceContext
	private EntityManager em;

	
	@Override
	public void saveZone(Zone Zone) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void saveWay(Way Way) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void saveLength(Length Length) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void savePoint(Point point) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<SiteType> findSiteTypes() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Site findSiteById(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void saveSite(Site site) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}







	@Override
	public Zone findZoneById(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}







	@Override
	public Way findWayById(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}







	@Override
	public Length findLengthById(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}







	@Override
	public Point findPointById(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}







	@Override
	public Area findAreaById(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}







	@Override
	public void saveArea(Area area) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}







	@Override
	public Collection<Area> findSiteByPostalCode(String postalcode) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
