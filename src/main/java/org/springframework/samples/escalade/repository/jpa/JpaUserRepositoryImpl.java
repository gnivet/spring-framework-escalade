/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.escalade.repository.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.orm.hibernate5.support.OpenSessionInViewFilter;
import org.springframework.samples.escalade.model.User;
import org.springframework.samples.escalade.repository.UserRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA implementation of the {@link UserRepository} longerface.
 *
 * @author Guillaume Nivet
 * @param
 * 
 */
@Repository
public class JpaUserRepositoryImpl implements UserRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	@SuppressWarnings("unchecked")
	public Collection<User> findAll() {
		return this.em.createQuery("SELECT distinct user FROM User user ORDER BY user.lastName, user.firstName")
				.getResultList();

	}

	/**
	 * Important: in the current version of this method, we load Users with all
	 * their Topos and Visits while we do not need Visits at all and we only need
	 * one property from the Topos objects (the 'name' property). There are some
	 * ways to improve it such as: - creating a Ligtweight class (example here:
	 * https://community.jboss.org/wiki/LightweightClass) - Turning on lazy-loading
	 * and using {@link OpenSessionInViewFilter}
	 */
	@SuppressWarnings("unchecked")
	public Collection<User> findByLastName(String lastName) {
		/*
		 * using 'join fetch' because a single query should load both owners and topos
		 * using 'left join fetch' because it might happen that an owner does not
		 * havetopos yet
		 */

		Query query = this.em.createQuery(
				"SELECT DISTINCT user FROM User user left join fetch user.topos WHERE user.lastName LIKE :lastName");
		query.setParameter("lastName", lastName + "%");
		return query.getResultList();
	}

	public User findById(long id) {
		/*
		 * using 'join fetch' because a single query should load both users and topos
		 * using 'left join fetch' because it might happen that an owner does not have
		 * topos yet SELECT setval('users_id_seq', (SELECT MAX(id) from "users"));
		 */
		Query query = this.em.createQuery("SELECT user FROM User user left join fetch user.topos WHERE user.id =:id");
		query.setParameter("id", id);
		return (User) query.getSingleResult();
	}

	@Override
	public void save(User user) {
		if (user.getId() == null) {
			this.em.persist(user);
		} else {
			this.em.merge(user);
		}

	}

	@Modifying
	public User deleteByUserId(long id) throws DataAccessException {
		Query query = this.em.createQuery("DELETE FROM User user WHERE user.id = :id");
		@SuppressWarnings("unused")
		long rowcount = query.setParameter("id", id).executeUpdate();
		return (User) query.getSingleResult();
	}

	public User selectByUserId(long id) throws DataAccessException {
		Query query = this.em.createQuery("select user from User user where user.id = ?");
		query.setParameter("id", id);
		return (User) query.getSingleResult();
	}

	public User selectUser(long id) throws DataAccessException {
		Query query = this.em.createQuery("select user from User user where user.id = :id");
		query.setParameter("id", id);
		return (User) query.getSingleResult();
	}

	
	/*
	 * @Override
	 * 
	 * @SuppressWarnings("unchecked") public Collection<User> findAll() { return
	 * this.em.createQuery(
	 * "SELECT distinct user FROM User user left join fetch user.specialties ORDER BY user.lastName, user.firstName"
	 * ) .getResultList();
	 * 
	 * }
	 */

	/*
	 * public Specialty findSpecialtyById(long id) throws DataAccessException { //
	 * TODO Auto-generated method stub return this.em.find(Specialty.class, id); }
	 * 
	 * public void saveSpecialty(Specialty specialty) throws DataAccessException {
	 * // TODO Auto-generated method stub if (specialty.getId() == null) {
	 * this.em.persist(specialty); } else { this.em.merge(specialty); } }
	 */
}