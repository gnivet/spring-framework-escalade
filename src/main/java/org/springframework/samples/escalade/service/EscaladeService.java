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

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Area;
import org.springframework.samples.escalade.model.Comment;
import org.springframework.samples.escalade.model.SiteType;
import org.springframework.samples.escalade.model.Topo;
import org.springframework.samples.escalade.model.Zone;

/**
 * Mostly used as a facade so all controllers have a single point of entry
 *
 * @author Guillaume Nivet
 */

public interface EscaladeService {

	Topo findTopoById(Integer id) throws DataAccessException;

	Area findAreaById(Integer id) throws DataAccessException;
	
	void saveTopo(Topo topo) throws DataAccessException;

	Collection<org.springframework.boot.autoconfigure.security.SecurityProperties.User> findUsers() throws DataAccessException;

	Collection<Comment> findCommentByName(String name) throws DataAccessException;
	
	String findLoggedInusername() throws DataAccessException;

	void autoLogin(String username, String password) throws DataAccessException;

	



	Collection<SiteType> findSiteTypes() throws DataAccessException;
	
	void saveArea(Area area);

	void saveZone( Zone zone)throws DataAccessException;

	Zone findZoneById(Integer zoneId)throws DataAccessException;

	Collection<Zone> findZoneByName(String name)throws DataAccessException;

	void saveComment( Comment comment);

	Comment findCommentById(Integer commentId);

	Collection<Area> findSiteByPostalCode(String postalcode);
	

	

}