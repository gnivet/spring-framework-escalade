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

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Area;
import org.springframework.samples.escalade.model.BaseEntity;
import org.springframework.samples.escalade.model.Length;
import org.springframework.samples.escalade.model.Point;
import org.springframework.samples.escalade.model.Site;
import org.springframework.samples.escalade.model.SiteType;
import org.springframework.samples.escalade.model.Topo;
import org.springframework.samples.escalade.model.Way;
import org.springframework.samples.escalade.model.Zone;

/**
 * Repository class for <code>Topo</code> domain objects All method names are
 * compliant with Spring Data naming conventions so this interface can easily be
 * extended for Spring Data See here:
 * http://static.springsource.org/spring-data/jpa/docs/current/reference/html/jpa.repositories.html#jpa.query-methods.query-creation
 *
 * @author Guillaume Nivet
 */

public interface TopoRepository {

	
	/**
	 * Retrieve a <code>Topo</code> from the data store by id.
	 *
	 * @param id the id to search for
	 * @return the <code>Topo</code> if found
	 * @throws org.springframework.dao.DataRetrievalFailureException if not found
	 */
	
	Site findById(long id) throws DataAccessException;

	/**
	 * Save a <code>Topo</code> to the data store, either inserting or updating it.
	 *
	 * @param Topo the <code>Topo</code> to save
	 * @see BaseEntity#isNew
	 */

	void save(Site site) throws DataAccessException;

	/**
	 * Retrieve a <code>Zone</code> from the data store by id.
	 *
	 * @param id the id to search for
	 * @return the <code>Zone</code> if found
	 * @throws org.springframework.dao.DataRetrievalFailureException if not found
	 */
	Zone findZoneById(long id) throws DataAccessException;

	/**
	 * Save a <code>Zone</code> to the data store, either inserting or updating it.
	 *
	 * @param Zone the <code>Zone</code> to save
	 * @see BaseEntity#isNew
	 */
	void saveZone(Zone Zone) throws DataAccessException;

	/**
	 * Retrieve a <code>Way</code> from the data store by id.
	 *
	 * @param id the id to search for
	 * @return the <code>Way</code> if found
	 * @throws org.springframework.dao.DataRetrievalFailureException if not found
	 */
	Way findWayById(long id) throws DataAccessException;

	/**
	 * Save a <code>Way</code> to the data store, either inserting or updating it.
	 *
	 * @param Zone the <code>Way</code> to save
	 * @see BaseEntity#isNew
	 */
	void saveWay(Way Way) throws DataAccessException;

	
	/**
	 * Retrieve a <code>Length</code> from the data store by id.
	 *
	 * @param id the id to search for
	 * @return the <code>Length</code> if found
	 * @throws org.springframework.dao.DataRetrievalFailureException if not found
	 */
	Length findLengthById(long id) throws DataAccessException;

	/**
	 * Save a <code>Length</code> to the data store, either inserting or updating
	 * it.
	 *
	 * @param Zone the <code>Length</code> to save
	 * @see BaseEntity#isNew
	 */
	void saveLength(Length Length) throws DataAccessException;

	/**
	 * Retrieve a <code>Point</code> from the data store by id.
	 *
	 * @param id the id to search for
	 * @return the <code>Point</code> if found
	 * @throws org.springframework.dao.DataRetrievalFailureException if not found
	 */
	Point findPointById(long id) throws DataAccessException;

	/**
	 * Save a <code>Point</code> to the data store, either inserting or updating it.
	 *
	 * @param Zone the <code>Point</code> to save
	 * @see BaseEntity#isNew
	 */
	void savePoint(Point Point) throws DataAccessException;

	/**
	 * Retrieve a <code>Area</code> from the data store by id.
	 *
	 * @param id the id to search for
	 * @return the <code>Area</code> if found
	 * @throws org.springframework.dao.DataRetrievalFailureException if not found
	 */
	Area findAreaById(long id) throws DataAccessException;

	/**
	 * Save a <code>Area</code> to the data store, either inserting or updating it.
	 *
	 * @param Zone the <code>Area</code> to save
	 * @see BaseEntity#isNew
	 */
	void saveArea(Area Area) throws DataAccessException;

	Collection<SiteType> findSiteTypes();

	void save(Topo topo);
}
