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
			if (topoBkg.getId() == null) {
				this.em.persist(topoBkg);
			} else {
				this.em.merge(topoBkg);
			}
		} catch (ConstraintViolationException e) {
			return null;
		}
		return topoBkg;
	}

	@Override
	public TopoBkg updateTopoBkg(TopoBkg topoBkg) throws escaladeException {
		// TODO Auto-generated method stub

		try {
			if (topoBkg.getId() == null) {
				this.em.persist(topoBkg);
			} else {
				this.em.merge(topoBkg);
			}
		} catch (RuntimeException e) {
			throw new escaladeException(e.getMessage(), e);
		}
		return topoBkg;
	}

	/*
	 * @SuppressWarnings("unchecked") public Collection<TopoBkg>
	 * findTopoBkgByName(String name) { // TODO Auto-generated method stub
	 *
	 * Query query = this.em.
	 * createQuery("SELECT DISTINCT topoBkg from TopoBkg topoBkg WHERE topoBkg.name LIKE :name"
	 * ); query.setParameter("name", "%" + name + "%"); return
	 * query.getResultList(); }
	 */

	@Override
	public Topo findTopoBookedBytopoBkgId(@NotNull Integer topoBkgId) {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("select topoBkg from TopoBkg topoBkg where topoBkg.topoBkgId = :topoBkgId");
		query.setParameter("topoBkgId", topoBkgId);
		return (Topo) query.getSingleResult();
	}

	/*
	 *
	 * with contrats as ( select DISTINCT(excvctr) as contrat,ROW_NUMBER()
	 * OVER(ORDER BY excvctr DESC) AS RN from ALDDTA.EXCTRVEH ) SELECT * FROM
	 * contrats WHERE RN BETWEEN 200 AND 400 order by contrat desc
	 *
	 *
	 *
	 *
	 */

	@Override
	public TopoBkg getAllTopoBkgById(Integer topoBkgId) {
		// TODO Auto-generated method stub

		Query query = this.em.createQuery("SELECT topoBkg FROM TopoBkg topoBkg  where topoBkg.id = :topoBkgId");

		query.setParameter("topoBkgId", topoBkgId);
		return (TopoBkg) query.getSingleResult();

	}

	/*
	 * @Override public Owner findById(int id) { // using 'join fetch' because a
	 * single query should load both owners and pets // using 'left join fetch'
	 * because it might happen that an owner does not have pets yet Query query =
	 * this.em.
	 * createQuery("SELECT owner FROM Owner owner left join fetch owner.pets WHERE owner.id =:id"
	 * ); query.setParameter("id", id); return (Owner) query.getSingleResult(); }
	 *
	 */

	/*
	 * If boolean_flag = true ==> topoBkg record can be created
	 */
	@SuppressWarnings("unused")
	private boolean boolean_flag;

	@Override
	public Boolean checkToposBookedByID(Integer topoId) {

		Query query = this.em.createQuery("select topoBkg from  TopoBkg topoBkg where topoBkg.topoId = :topoId");

		query.setParameter("topoId", topoId);
		boolean_flag = false;

		if (query.getSingleResult() == null) {
			boolean_flag = true;
		} else {
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
	public Collection<TopoBkg> findToposBkgs(Integer id) {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("select topoBkg from  TopoBkg topoBkg where topoBkg.topo_id = :id");

		query.setParameter("id", id);

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override

	public Collection<TopoBkg> findTopoBkgByUserName(String userName) {

		Query query = this.em.createQuery(
				"select topoBkg from TopoBkg topoBkg where user_id in (select id from User user where userName like: userName)");
		query.setParameter("userName", userName + "%");
		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<TopoBkg> findTopoBkgByUserId(Integer userId) {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery(
				"SELECT DISTINCT topoBkg, user FROM User user left join fetch user.topoBkgs WHERE user.id = :userId");
		query.setParameter("userId", userId);
		return query.getResultList();
	}

	/*
	 * long result = (Integer) this.em .createNativeQuery("select count(1) from topo")
	 * .getSingleResult();
	 */

	@Override
	@SuppressWarnings("unchecked")
	public Collection<TopoBkg> findTopoBkgs() {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("SELECT DISTINCT topoBkg, user FROM User user left join fetch user.topoBkgs");
		return query.getResultList();

	}

	/*
	 * @SuppressWarnings("unchecked")
	 *
	 * @Override public Collection<TopoBkg> findTopoBkgByUserName(String userName)
	 * throws DataAccessException { // TODO Auto-generated method stub user left
	 * join fetch user.topoBkgs Query query = this.em.
	 * createQuery("(SELECT topoBkg FROM TopoBkg topoBkg WHERE topoBkg.user.userName = :userName , TopoBkg.class"
	 * ); query.setParameter("userName", "%" + userName + "%"); return
	 * query.getResultList(); }
	 */

	@Override
	public Collection<TopoBkg> findTopoBkgByName(String name) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	@SuppressWarnings("unchecked")
	public Collection <TopoBkg> findTopoBkg(String name) throws DataAccessException {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("select topoBkg from  TopoBkg topoBkg where topoBkg.topo_id in (select topo_id from Topo topo where topo.name like : name");
		query.setParameter("name", name + "%");
		return query.getResultList();
	}

	/*
	 * @Override public Collection<TopoBkg> findTopoBkgByUserName(String name)
	 * throws DataAccessException { // TODO Auto-generated method stub Query query =
	 * this.em.
	 * createQuery("(SELECT distinct topoBkg FROM TopoBkg topoBkg left join fetch user.topoBkgs WHERE user.userName = :userName"
	 * ); query.setParameter("userName", name + "%"); return query.getResultList();
	 * }
	 */

	/*
	 * @SuppressWarnings("unchecked") public Collection<Owner> findByLastName(String
	 * lastName) { // using 'join fetch' because a single query should load both
	 * owners and pets // using 'left join fetch' because it might happen that an
	 * owner does not have pets yet Query query = this.em.
	 * createQuery("SELECT DISTINCT owner FROM Owner owner left join fetch owner.pets WHERE owner.lastName LIKE :lastName"
	 * ); query.setParameter("lastName", lastName + "%"); return
	 * query.getResultList(); }
	 */

}