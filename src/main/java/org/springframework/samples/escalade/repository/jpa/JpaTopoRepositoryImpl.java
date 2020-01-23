package org.springframework.samples.escalade.repository.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.samples.escalade.model.Topo;
import org.springframework.samples.escalade.model.TopoType;
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
		
		@Override
		public Topo findById(long id) {
			// using 'join fetch' because a single query should load both areas and topos
			// using 'left join fetch' because it might happen that an owner does not have
			// topos yet

			Query query = this.em.createQuery("SELECT topo FROM Topo topo WHERE topo.id =:id");
			query.setParameter("id", id);
			return (Topo) query.getSingleResult();
		}

		public void save(Topo Topo) {
			if (Topo.getId() == null) {
				this.em.persist(Topo);
			} else {
				this.em.merge(Topo);
			}
		}

		@Override
		public Collection<TopoType> findTopoTypes() {
			// TODO Auto-generated method stub
			return null;
		}	
}
