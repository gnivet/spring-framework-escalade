package org.springframework.samples.escalade.repository.jpa;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Topo;
import org.springframework.samples.escalade.repository.TopoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class JpaTopoRepositoryImpl implements TopoRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Topo findTopoById(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("SELECT topo FROM Topo topo WHERE topo.id =:id");
		query.setParameter("id", id);
		return (Topo) query.getSingleResult();
	}

	@Override
	public Topo saveTopo(Topo topo) throws DataAccessException {
		// TODO Auto-generated method stub
		if (topo.getId() == null) {
			this.em.persist(topo);
		} else {
			this.em.merge(topo);
		}
		return topo;
	}

	@Override
	public Topo updateTopo(Topo topo) {
		// TODO Auto-generated method stub
		if (!this.em.contains(topo)) {
			this.em.merge(topo);
		}

		return topo;
	}


	@SuppressWarnings("unchecked")
	@Override
	public Collection<Topo> findTopoByName() throws DataAccessException {
		// TODO Auto-generated method stub

		Query query = this.em
				.createQuery("SELECT DISTINCT topo from Topo topo");

		return query.getResultList();
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<Topo> findTopoByUserName(String userName) {
		// TODO Auto-generated method stub

		Query query = this.em.createQuery("SELECT topo FROM Topo topo WHERE topo.user.userName like :userName");

		query.setParameter("userName", "%" + userName + "%");
		return  query.getResultList();
	}








	@SuppressWarnings("unchecked")
	public List<Topo> getJoinInformation(String userName) {
		// TODO Auto-generated method stub

		Query query = this.em.createQuery("SELECT new TopoResponse(t.name, t.available, t.comment_date, t.description, u.first_name, u.last_name ) FROM Topo t JOIN u.userName User u where u.userName like: userName");
		{
				query.setParameter("userName", "%" + userName + "%");
		//return  query.getResultList();
		return query.getResultList() ;	}



	}


	@SuppressWarnings("unchecked")
	@Override

	public Collection<Topo> findTopoAvailableByUserId(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		Query query = this.em
				.createQuery("SELECT DISTINCT topo from Topo topo WHERE user_id = :id and topo.available = true");
		query.setParameter("id", id);

		return query.getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Topo> findTopoByUserId(Integer id) {
		// TODO Auto-generated method stub
	Query query = this.em.createQuery("SELECT topo FROM Topo topo WHERE user_id = :id");

		query.setParameter("id",  id );
		return  query.getResultList();
	}

	@Override
	public Topo findTopoByNames(String name) throws DataAccessException {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("SELECT topo FROM Topo topo WHERE topo.name like :name");
		query.setParameter("name", "%" + name + "%" );
		return (Topo) query.getResultList();
	}

	@Override
	public Topo findTopo() throws DataAccessException {
		return this.em.createQuery("SELECT topo FROM Topo topo" , Topo.class)
                .getSingleResult();
	}

	@Override
	public Collection<Topo> findTopoAvailableByName() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}







	}




