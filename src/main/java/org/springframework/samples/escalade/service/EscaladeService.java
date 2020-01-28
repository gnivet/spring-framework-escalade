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
import org.springframework.samples.escalade.model.Area;
import org.springframework.samples.escalade.model.Comment;
import org.springframework.samples.escalade.model.SiteType;
import org.springframework.samples.escalade.model.Topo;
import org.springframework.samples.escalade.model.TopoType;
import org.springframework.samples.escalade.model.User;
import org.springframework.samples.escalade.model.Zone;
import org.springframework.stereotype.Service;




/**
 * Mostly used as a facade so all controllers have a single point of entry
 *
 * @author Guillaume Nivet
 */

public interface EscaladeService {

	Topo findTopoById(long id) throws DataAccessException;

	Area findAreaById(long id) throws DataAccessException;
	/*
	void saveCommentaire(Commentaire commentaire) throws DataAccessException;
	*/
	void saveTopo(Topo topo) throws DataAccessException;

	Collection<User> findUsers() throws DataAccessException;

	Collection<Comment> findCommentByName(String name) throws DataAccessException;

	void saveUser(org.springframework.security.core.userdetails.@Valid User user) throws DataAccessException;

	User findUserById(long userId) throws DataAccessException;

	Collection<User> findUserByLastName(String lastName) throws DataAccessException;

	
	String findLoggedInusername() throws DataAccessException;

	void autoLogin(String username, String password) throws DataAccessException;

	Collection<User> findUserByusername(String username) throws DataAccessException;

	void saveUser(User user) throws DataAccessException;

	Collection<SiteType> findSiteTypes() throws DataAccessException;
	
	void saveArea(Area area);

	Collection<TopoType> findTopoTypes();

	void saveZone(@Valid Zone zone)throws DataAccessException;

	Zone findZoneById(long zoneId)throws DataAccessException;

	Collection<Zone> findZoneByName(String name)throws DataAccessException;

	void saveComment(@Valid Comment comment);

	Comment findCommentById(long commentId);

	Collection<Area> findSiteByPostalCode(String postalcode);

	

}