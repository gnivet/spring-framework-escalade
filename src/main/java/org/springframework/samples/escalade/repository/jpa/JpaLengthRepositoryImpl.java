package org.springframework.samples.escalade.repository.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Length;
import org.springframework.samples.escalade.model.NamedEntity;
import org.springframework.samples.escalade.repository.LengthRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class JpaLengthRepositoryImpl implements LengthRepository{


		@PersistenceContext
		private EntityManager em;

		@Override
		public Length findLengthById(Integer id) {
			return this.em.find(Length.class, id);
		}

		// Add Way to Site form
		@Override
		public Length saveLength(Length Length) throws DataAccessException {
			if (Length.getId() == null) {
				this.em.persist(Length);
			} else {
				this.em.merge(Length);
			}
			return Length;

		}
		public Length findById(Integer id) {
		Query query = this.em.createQuery("SELECT length FROM Length length WHERE length.id =:id");
		query.setParameter("id", id);
		return (Length) query.getSingleResult();
		}

		@Override
		@SuppressWarnings("unchecked")
		public Collection<Length> findLengthByName(String name) throws DataAccessException {
			// TODO Auto-generated method stub

				Query query = this.em.createQuery("SELECT length FROM Length length WHERE length.name not like :name");
				query.setParameter("name", "%" + name + "%");
				return  query.getResultList();
		}

		@Override
		public NamedEntity updateLength(Length length) throws DataAccessException {
			// TODO Auto-generated method stub
			return null;
		}





	}

