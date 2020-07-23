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
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.orm.hibernate5.support.OpenSessionInViewFilter;
import org.springframework.samples.escalade.model.TopoBkg;
import org.springframework.samples.escalade.model.User;
import org.springframework.samples.escalade.repository.UserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * JPA implementation of the {@link OwnerRepository} interface.
 *
 * @author Guillaume Nivet 
 */

@Repository
@Transactional
public class JpaUserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager em;


    /**
     * Important: in the current version of this method, we load Owners with all their Pets and Visits while
     * we do not need Visits at all and we only need one property from the Pet objects (the 'name' property).
     * There are some ways to improve it such as:
     * - creating a Ligtweight class (example here: https://community.jboss.org/wiki/LightweightClass)
     * - Turning on lazy-loading and using {@link OpenSessionInViewFilter}
     */
   

   

	@Override
	public List<org.springframework.samples.escalade.model.User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<org.springframework.samples.escalade.model.User> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public <S extends org.springframework.samples.escalade.model.User> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends org.springframework.samples.escalade.model.User> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<org.springframework.samples.escalade.model.User> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public <S extends org.springframework.samples.escalade.model.User> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends org.springframework.samples.escalade.model.User> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<org.springframework.samples.escalade.model.User> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends org.springframework.samples.escalade.model.User> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}


	

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	

	@Override
	public void delete(org.springframework.samples.escalade.model.User entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends org.springframework.samples.escalade.model.User> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends org.springframework.samples.escalade.model.User> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends org.springframework.samples.escalade.model.User> Page<S> findAll(Example<S> example,
			Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends org.springframework.samples.escalade.model.User> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends org.springframework.samples.escalade.model.User> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	


	@Override
	public List<org.springframework.samples.escalade.model.User> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public org.springframework.samples.escalade.model.User getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Optional<org.springframework.samples.escalade.model.User> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public org.springframework.samples.escalade.model.User findById(Integer userId) {
		// TODO Auto-generated method stub
		 Query query = this.em.createQuery("SELECT DISTINCT owner FROM User user left join fetch user.sites WHERE user.userId LIKE :userId");
	        query.setParameter("userId", userId + "%");
	        return (org.springframework.samples.escalade.model.User) query.getResultList();
	        
	}




	

	 @SuppressWarnings("unchecked")
	    public Collection<User> findByUserNames(String userName) {
	        // using 'join fetch' because a single query should load both users and sites
	        // using 'left join fetch' because it might happen that an user does not have sites yet
	        Query query = this.em.createQuery("SELECT DISTINCT user FROM User user left join fetch user.sites WHERE user.userName LIKE :userName");
	        query.setParameter("userName", userName + "%");
	        return query.getResultList();
	    }
	 
	 
	 
	 
	 
	 
	

	@Override
	public long countByEmail(String email) {
		// TODO Auto-generated method stub
		return (Long) this.em.createQuery("select count(u) from User u where u.email = :email")
                .setParameter("email", email)
                .getSingleResult();
	}

	@Override
	public List<User> findByLastNameAndEmail(String lastName, String email) {
		return this.em.createQuery("select u from User u where u.lastName = :lastName and u.email = :email", User.class)
                .setParameter("lastName", lastName)
                .setParameter("email", email)
                .getResultList();
	}

	@Override
	public List<User> findByLastNameOrEmail(String lastName, String email) {
		// TODO Auto-generated method stub
		return this.em.createQuery("select u from User u where u.lastName = :lastName or u.email = :email", User.class)
                .setParameter("lastName", lastName)
                .setParameter("email", email)
                .getResultList();
	}

	@Override
	public List<User> findByLastNameAndFirstName(String lastName, String firstName) {
		// TODO Auto-generated method stub
		return this.em.createQuery("select u from User u where u.lastName = :lastName and u.firstName = :firstName", User.class)
                .setParameter("lastName", lastName)
                .setParameter("firstName", firstName)
                .getResultList();
         
	}

	@Override
	public List<TopoBkg> getAllTopoBkgsUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findSingleTopoBkgById(Integer topoBkgId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByUserName(String userName) {
		// TODO Auto-generated method stub
		
		
			return (User) this.em.createQuery("select u from User u where u.userName = :userName" , User.class)
	                .setParameter("userName", userName )
	                .getSingleResult();
			
		
	}


}
