package org.springframework.samples.escalade.repository.jpa;

import java.util.Collection;
import java.util.List;

import javax.management.Query;
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

	@SuppressWarnings("unchecked")
	public Collection<Topo> findTopoByName(String name) {
		// TODO Auto-generated method stub

		Query query = this.em.createQuery("SELECT DISTINCT topo from Topo topo WHERE topo.name LIKE :name");
		query.setParameter("name", name + "%");
		return query.getResultList();
	}

	
	public Topo findById(long id) {
		// using 'join fetch' because a single query should load both areas and topos
		// using 'left join fetch' because it might happen that an owner does not have
		// topos yet

		Query query = this.em.createQuery("SELECT topo FROM Topo topo WHERE topo.id =:id");
		query.setParameter("id", id);
		return (Topo) query.getSingleResult();
	}

	public void saveTopo(Topo Topo) {
		if (Topo.getId() == null) {
			this.em.persist(Topo);
		} else {
			this.em.merge(Topo);
		}
	}

	public Collection<TopoType> findTopoTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public void saveZone(Zone zone) {
		if (Zone.getId() == null) {
			this.em.persist(Zone);
		} else {
			this.em.merge(Zone);
		}
		
	}


	@Override
	public void saveWay(Way way) {		
		if (Way.getId() == null) {
			this.em.persist(Way);
		}
		else	
			this.em.merge(Way);
		}
		
	}


	@Override
	public void saveLength(Length length) {
		if (Length.getId() == null) {
			this.em.persist(Length);
		}
		else	
			this.em.merge(Length);
		}
		
	}


	@Override
	public void savePoint(Point point) {
		if (Point.getId() == null) {
			this.em.persist(Point);
		}
		else	
			this.em.merge(Point);
		
	}


	@Override
	public List<TopoType> findTopoTypes() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}


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
}
