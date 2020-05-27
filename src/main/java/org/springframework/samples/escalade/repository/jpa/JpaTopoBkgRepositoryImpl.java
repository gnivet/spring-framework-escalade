package org.springframework.samples.escalade.repository.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Topo;
import org.springframework.samples.escalade.model.TopoBkg;
import org.springframework.samples.escalade.repository.TopoBkgRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class JpaTopoBkgRepositoryImpl implements TopoBkgRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public TopoBkg findTopoBkgById(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("SELECT topoBkg FROM TopoBkg topoBkg WHERE topoBkg.id =:id");
		query.setParameter("id", id);
		return (TopoBkg) query.getSingleResult();
	}

	/*
	 * 
	 */

	public String checkToposBookedByID(Integer topoId, Boolean boolean_flag) {
		Query query = this.em
				.createQuery("select topo from Topo topo left join fetch TopoBkg.topos where topo.topoId like :topoId");
		// Query query = this.em.createQuery("with req1 as (select * , ROW_NUMBER() OVER
		// (order by id) as RN from topo_bkgs tb where exists (select count(*) AS
		// nb_topo from topos t where tb.topo_id = t.id))\n" +
		// "select WHEN RN < 1 case then '1' WHEN RN >= 1 then '0' from req1;)");
		// Query query = this.em.createQuery("SELECT DISTINCT owner FROM User user left
		// join fetch user.sites WHERE user.userId LIKE :userId");
		query.setParameter("topoId", topoId);
		return (String) query.getSingleResult();

	}

	@Override
	public TopoBkg saveTopoBkg(TopoBkg topoBkg) throws DataAccessException {
		// TODO Auto-generated method stub
		try {
			if (topoBkg.getId() == null) {
				this.em.persist(topoBkg);
		    } else {
				this.em.merge(topoBkg);
		}
		}catch(ConstraintViolationException e) {
			return null;
		}
		return topoBkg;
	}

	@Override
	public TopoBkg updateTopoBkg(TopoBkg topoBkg) {
		// TODO Auto-generated method stub
		if (!this.em.contains(topoBkg))
			this.em.merge(topoBkg);

		return topoBkg;
	}

	@SuppressWarnings("unchecked")
	public Collection<TopoBkg> findTopoBkgByName(String name) {
		// TODO Auto-generated method stub

		Query query = this.em.createQuery("SELECT DISTINCT topoBkg from TopoBkg topoBkg WHERE topoBkg.name LIKE :name");
		query.setParameter("name", "%" + name + "%");
		return query.getResultList();
	}

	@Override
	public String checkToposBookedByID(Integer topoId) {
		Query query = this.em
				.createQuery("select topo from Topo topo left join fetch TopoBkg.topos where topo.topoId like :topoId");
		// Query query = this.em.createQuery("with req1 as (select * , ROW_NUMBER() OVER
		// (order by id) as RN from topo_bkgs tb where exists (select count(*) AS
		// nb_topo from topos t where tb.topo_id = t.id))\n" +
		// "select WHEN RN < 1 case then '1' WHEN RN >= 1 then '0' from req1;)");
		// Query query = this.em.createQuery("SELECT DISTINCT owner FROM User user left
		// join fetch user.sites WHERE user.userId LIKE :userId");
		query.setParameter("topoId", topoId);
		return (String) query.getSingleResult();

	}

	@Override
	public Topo findTopoBookedBytopoBkgId(@NotNull Integer topoBkgId) {
		// TODO Auto-generated method stub
		Query query = this.em
				.createQuery("select topoBkg from TopoBkg topoBkg where topoBkg.topoBkgId like :topoBkgId");		
		query.setParameter("topoBkgId", topoBkgId);
		return (Topo) query.getSingleResult();
	}

}
