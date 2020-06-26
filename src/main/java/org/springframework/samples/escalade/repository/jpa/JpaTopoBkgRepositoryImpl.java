package org.springframework.samples.escalade.repository.jpa;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Topo;
import org.springframework.samples.escalade.model.TopoBkg;
import org.springframework.samples.escalade.model.escaladeException;
import org.springframework.samples.escalade.repository.TopoBkgRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class JpaTopoBkgRepositoryImpl implements TopoBkgRepository {

	@PersistenceContext
	private EntityManager em;
	

	@SuppressWarnings("unchecked")
	@Override
	public List<TopoBkg> findTopoBkgById(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("SELECT topoBkg FROM TopoBkg topoBkg WHERE topoBkg.id = :id");
		query.setParameter("id", id);
		return query.getResultList();
					
		}
	


	@Override
	public TopoBkg saveTopoBkg(TopoBkg topoBkg) throws DataAccessException {
		// TODO Auto-generated method stub
		try {
			if (topoBkg.getId() == null ) {
				this.em.persist(topoBkg);
		    } else {
				this.em.merge(topoBkg);
		}
		}catch(ConstraintViolationException e) {
			return null;
		}
		return topoBkg;
	}

	public TopoBkg updateTopoBkg(TopoBkg topoBkg) throws escaladeException{
		// TODO Auto-generated method stub
		
		try {
			if (topoBkg.getId() == null ) {
				this.em.persist(topoBkg);
		    } else {
				this.em.merge(topoBkg);
		}
		}catch(RuntimeException e) {
			throw new escaladeException(e.getMessage(), e);
		}
		return topoBkg;
	}
	

	
	
	
	/*
	@SuppressWarnings("unchecked")
	public Collection<TopoBkg> findTopoBkgByName(String name) {
		// TODO Auto-generated method stub

		Query query = this.em.createQuery("SELECT DISTINCT topoBkg from TopoBkg topoBkg WHERE topoBkg.name LIKE :name");
		query.setParameter("name", "%" + name + "%");
		return query.getResultList();
	}
	*/
	

	@Override
	public Topo findTopoBookedBytopoBkgId(@NotNull Integer topoBkgId) {
		// TODO Auto-generated method stub
		Query query = this.em
				.createQuery("select topoBkg from TopoBkg topoBkg where topoBkg.topoBkgId = :topoBkgId");		
		query.setParameter("topoBkgId", topoBkgId);
		return (Topo) query.getSingleResult();
	}



	@Override
	public TopoBkg findSingleTopoBkgById(Integer topoBkgId) {
		// TODO Auto-generated method stub
		
		Query query = this.em
				.createQuery("select topoBkg from TopoBkg topoBkg where topoBkg.topoBkgId = :topoBkgId");		
		query.setParameter("topoBkgId", topoBkgId);
		
		return null;
		
	}

	/*
	 *  If boolean_flag = true ==> topoBkg record can be created
	 */
	@SuppressWarnings("unused")
	private boolean boolean_flag;
	@Override
	public Boolean checkToposBookedByID(Integer topoId ) {
		
		Query query = this.em
				.createQuery("select topoBkg from  TopoBkg topoBkg where topoBkg.topoId = :topoId");
		
		
		query.setParameter("topoId", topoId );
		boolean_flag = false;
		
		if (query.getSingleResult() == null)
		{	
			 boolean_flag = true;
		}else
		{
			 boolean_flag = false;
		}
		return (Boolean) query.getSingleResult();
	}



	@Override
	public List<TopoBkg> findByIdinIgnoreCaseIn(List<String> topo) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<TopoBkg> findByIdinIgnoreCaseIn(Topo topo) {
		// TODO Auto-generated method stub
		return null;
	}



	@SuppressWarnings("unchecked")
	@Override
	public Collection<TopoBkg> findToposBkgs(Integer topo_id) {
		// TODO Auto-generated method stub
		Query query = this.em
				.createQuery("select topoBkg from  TopoBkg topoBkg where topoBkg.topo_id = :topo_id");
		
		
		query.setParameter("topoId", topo_id);
		
		return query.getResultList();
	}

	/*
	long result = (Long) this.em
            .createNativeQuery("select count(1) from topo")
            .getSingleResult();
	*/
	
	
	
}