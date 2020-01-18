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
package org.springframework.samples.escalade.service;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.User;
import org.springframework.samples.escalade.model.Area;
import org.springframework.samples.escalade.model.Commentaire;
import org.springframework.samples.escalade.model.Site;
import org.springframework.samples.escalade.model.SiteType;
import org.springframework.samples.escalade.model.Topo;


/**
 * Mostly used as a facade so all controllers have a single point of entry
 *
 * @author Guillaume Nivet
 */
public interface EscaladeService {

	Topo findTopoById(long id) throws DataAccessException;

	Area findAreaById(long id) throws DataAccessException;

	void saveCommentaire(@Valid Commentaire commentaire) throws DataAccessException;

	void saveTopo(Site Topo) throws DataAccessException;

	Collection<User> findUsers() throws DataAccessException;

	Collection<Area> findTopoByPostalCode(String postalCode) throws DataAccessException;

	void saveUser(org.springframework.security.core.userdetails.@Valid User user) throws DataAccessException;

	User findUserById(long userId) throws DataAccessException;

	Collection<User> findUserByLastName(String lastName) throws DataAccessException;

	
	String findLoggedInUsername() throws DataAccessException;

	void autoLogin(String username, String password) throws DataAccessException;

	Collection<User> findUserByUserName(String userName) throws DataAccessException;

	void saveUser(User user) throws DataAccessException;

	Collection<SiteType> findSiteTypes() throws DataAccessException;

	Collection<Commentaire> findSiteByName(String commentaire);

	void saveArea(@Valid Area area);

	Commentaire findCommentaireById(long commentaireId);

}