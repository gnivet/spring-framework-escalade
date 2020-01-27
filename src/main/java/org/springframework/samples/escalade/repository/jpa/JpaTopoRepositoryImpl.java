package org.springframework.samples.escalade.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Area;
import org.springframework.samples.escalade.model.Length;
import org.springframework.samples.escalade.model.Point;
import org.springframework.samples.escalade.model.Topo;
import org.springframework.samples.escalade.model.TopoType;
import org.springframework.samples.escalade.model.Way;
import org.springframework.samples.escalade.model.Zone;
import org.springframework.samples.escalade.repository.AreaRepository;
import org.springframework.samples.escalade.repository.TopoRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA implementation of the {@link AreaRepository} longerface.
 *
 * @author Guillaume Nivet
 * @since 3.12.2019
 */
@Repository
public class JpaTopoRepositoryImpl implements TopoRepository {

	@PersistenceContext
	private EntityManager em;

	

	@Override
	public Topo findById(Long id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Zone findZoneById(Long id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Way findWayById(Long id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Length findLengthById(Long id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Point findPointById(Long id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Area findAreaById(Long id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void saveArea(Area Area) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<TopoType> findTopoTypes() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void saveTopo(Topo Topo) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}


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
	
	
	
	
}
