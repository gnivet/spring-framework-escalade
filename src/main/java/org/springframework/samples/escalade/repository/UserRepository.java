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
package org.springframework.samples.escalade.repository;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.User;


/**
 * Repository class for <code>User</code> domain objects All method names are
 * compliant with Spring Data naming conventions so this interface can easily be
 * extended for Spring Data See here:
 * http://static.springsource.org/spring-data/jpa/docs/current/reference/html/jpa.repositories.html#jpa.query-methods.query-creation
 *
 * @author Guillaume Nivet
 * @param <userDelete>
 */
public interface UserRepository {

	/**
	 * Retrieve an <code>User</code> from the data store by id.
	 *
	 * @param id the id to search for
	 * @return the <code>User</code> if found
	 * @throws org.springframework.dao.DataRetrievalFailureException if not found
	 */
	User findById(Long id) throws DataAccessException;

	void save(User user) throws DataAccessException;

	Collection<User> findByLastName(String lastName) throws DataAccessException;

	Collection<User> findAll() throws DataAccessException;

	@Transactional
	User deleteByUserId(Long id) throws DataAccessException;

	User selectUser(Long id) throws DataAccessException;

	User selectByUserId(Long id) throws DataAccessException;

	User findUserById(long id);
	
	

	User findByUsername(String username);



	/**
	 * Retrieve all <code>User</code>s from the data store.
	 *
	 * @return a <code>Collection</code> of <code>User
	 * 
	 * </code>
	 */

}