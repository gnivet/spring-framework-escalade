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
import org.springframework.samples.escalade.model.Site;
import org.springframework.samples.escalade.model.SiteType;
import org.springframework.samples.escalade.model.Topo;
import org.springframework.samples.escalade.model.User;
import org.springframework.samples.escalade.model.Zone;

/**
 * Mostly used as a facade so all controllers have a single point of entry
 *
 * @author Guillaume Nivet
 */

public interface EscaladeService {
	
	/*
	 * User
	 */

	User findUserByID (Integer id)  throws DataAccessException;
	
	
	/*
	 * Topo
	 */
	
	Topo findTopoById(Integer id) throws DataAccessException;
	void saveTopo(Topo topo) throws DataAccessException;

	
	/*
	 * Area
	 */

	Area findAreaById(Integer id) throws DataAccessException;
	
	void saveArea(Area area)throws DataAccessException;

	Collection<Area> findSiteByPostalCode(String postalcode)throws DataAccessException;

	/*
	 * Comment
	 */
	
	Collection<org.springframework.boot.autoconfigure.security.SecurityProperties.User> findUsers() throws DataAccessException;
	
	void saveComment( Comment comment)throws DataAccessException;

	Comment findCommentById(Integer id)throws DataAccessException;

	Collection<Comment> findCommentByName(String name) throws DataAccessException;
	
	/*
	 * Zone
	 */
	
	void saveZone( Zone zone)throws DataAccessException;

	Zone findZoneById(Integer id)throws DataAccessException;

	Collection<Zone> findZoneByName(String name) throws DataAccessException;
	
	
	
	/*
	 * Site
	 */
	
	void saveSite(Site site)throws DataAccessException;

	Site findSiteById(Integer id)throws DataAccessException;
	
	
	/*
	 * SiteType
	 */
	
	Collection<SiteType> findSiteTypes() throws DataAccessException;
	
	
	String findLoggedInusername() throws DataAccessException;

	void autoLogin(String username, String password) throws DataAccessException;

	
	

	

}