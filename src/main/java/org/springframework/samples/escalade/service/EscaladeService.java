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
import java.util.List;

import javax.validation.Valid;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Area;
import org.springframework.samples.escalade.model.Comment;
import org.springframework.samples.escalade.model.Length;
import org.springframework.samples.escalade.model.NamedEntity;
import org.springframework.samples.escalade.model.Point;
import org.springframework.samples.escalade.model.Site;
import org.springframework.samples.escalade.model.SiteType;
import org.springframework.samples.escalade.model.Topo;
import org.springframework.samples.escalade.model.User;
import org.springframework.samples.escalade.model.Visit;
import org.springframework.samples.escalade.model.Way;
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

	User findUserByID(Integer id) throws DataAccessException;

	String findLoggedInusername() throws DataAccessException;

	void autoLogin(String username, String password) throws DataAccessException;

	/*
	 * Topo
	 */

	Topo findTopoById(Integer id) throws DataAccessException;

	void saveTopo(Topo topo) throws DataAccessException;

	/*
	 * Area
	 */

	Area findAreaById(Integer id) throws DataAccessException;

	Area saveArea(Area area) throws DataAccessException;

	Collection<Area> findSiteByPostalCode(String postalcode) throws DataAccessException;
	
	

	/*
	 * Comment
	 */

	Collection<org.springframework.boot.autoconfigure.security.SecurityProperties.User> findUsers()
			throws DataAccessException;

	@Valid Comment saveComment(Comment comment) throws DataAccessException;

	Comment findCommentById(Integer id) throws DataAccessException;

	Collection<Comment> findCommentByName(String name) throws DataAccessException;
	
	Long findCommentNumber(String username) throws DataAccessException;

	/*
	 * Zone
	 */

	Zone saveZone(Zone zone) throws DataAccessException;

	Zone findZoneById(Integer id) throws DataAccessException;

	Collection<Zone> findZoneByName(String name) throws DataAccessException;

	/*
	 * Site
	 */

	Site saveSite(Site site) throws DataAccessException;

	 Site findSiteById(Integer id) throws DataAccessException;
	
	Site findSiteOwnedbyUser(String userName) throws DataAccessException;
	
	Collection<Site> findSiteByName(String name) throws DataAccessException;
	
	/*
	 * SiteType
	 */

	Collection<SiteType> findSiteTypesCollection() throws DataAccessException;

	List<SiteType> findSiteTypesList() throws DataAccessException;

	

	SiteType findById(Integer id) throws DataAccessException;

	Collection<SiteType> findSiteTypeByName(String name);

	SiteType findSiteTypeById(Integer siteTypeId);


	
	Collection<SiteType> findSiteTypes()throws DataAccessException;

	/*
	 * Way
	 */
	
	Way saveway(Way way)throws DataAccessException;

	Collection<Way> findWayByName(String name)throws DataAccessException;

	Way findWayById(Integer id)throws DataAccessException;

	NamedEntity updateArea(Area area)throws DataAccessException;

	Collection<Site> findSiteByName1(String name)throws DataAccessException;

	NamedEntity updateZone(Zone zone)throws DataAccessException;

	

	/*
	 * Length
	 */
	
	Length saveLength(Length length)throws DataAccessException;

	Collection<Length> findLengthByName(String name)throws DataAccessException;
	
	
	
	Length findLengthById(Integer lengthId)throws DataAccessException;

	
	
	
	
	/*
	 * Point
	 */
	void savePoint(Point point) throws DataAccessException;

	Collection<Point> findPointByName(String name)throws DataAccessException;
	
	Point findPointById(Integer pointId)throws DataAccessException;

	void saveVisit(@Valid Visit visit)throws DataAccessException;;

	Long findByUsername(String userName)throws DataAccessException;

	Long findSiteOwnedByUsername(String userName)throws DataAccessException;

	Collection<Comment> findCommentByUsername(String userName)throws DataAccessException;

	NamedEntity updateComment(Comment comment)throws DataAccessException;


	SiteType saveSiteType( SiteType siteType)throws DataAccessException;

	void updateComment(SiteType siteTypeToModify)throws DataAccessException;

	
	//NamedEntity updateArea(Area area)throws DataAccessException;
	

	
	
}