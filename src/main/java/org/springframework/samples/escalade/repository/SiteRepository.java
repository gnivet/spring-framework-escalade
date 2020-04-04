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
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Area;
import org.springframework.samples.escalade.model.BaseEntity;
import org.springframework.samples.escalade.model.Length;
import org.springframework.samples.escalade.model.NamedEntity;
import org.springframework.samples.escalade.model.Point;
import org.springframework.samples.escalade.model.Site;
import org.springframework.samples.escalade.model.SiteType;
import org.springframework.samples.escalade.model.Way;
import org.springframework.samples.escalade.model.Zone;

/**
 * Repository class for <code>Topo</code> domain objects All method names are compliant with Spring Data naming
 * conventions so this Integererface can easily be extended for Spring Data See here: http://static.springsource.org/spring-data/jpa/docs/current/reference/html/jpa.repositories.html#jpa.query-methods.query-creation
 *
 * @author Guillaume Nivet
 */
public interface SiteRepository {

	 /**
     * Retrieve a <code>Site</code> from the data store by id.
     *
     * @param userName the userName to search for
	 * @param siteId 
	 * @return the <code>Site</code> if found
     * @throws org.springframework.dao.DataRetrievalFailureException if not found
     */
    Integer findSiteOwnedbyUser(String userName, Integer siteId) throws DataAccessException;
 
    List<Site> findSite() throws DataAccessException;
    

	List<SiteType> findSiteTypes() throws DataAccessException;

    /**
     * Retrieve a <code>Site</code> from the data store by id.
     *
     * @param id the id to search for
     * @return the <code>Site</code> if found
     * @throws org.springframework.dao.DataRetrievalFailureException if not found
     */
    Site findSiteById(Integer id) throws DataAccessException;

    /**
     * Save a <code>Site</code> to the data store, either inserting or updating it.
     *
     * @param Topo the <code>Site</code> to save
     * @return 
     * @see BaseEntity#isNew
     */
    
    Site saveSite(Site site)  throws DataAccessException;
   
    /**
     * Retrieve a <code>Zone</code> from the data store by id.
     *
     * @param id the id to search for
     * @return the <code>Zone</code> if found
     * @throws org.springframework.dao.DataRetrievalFailureException if not found
     */
    
    Zone findZoneById(Integer id)  throws DataAccessException;
    
    /**
     * Save a <code>Zone</code> to the data store, either inserting or updating it.
     *
     * @param Zone the <code>Zone</code> to save
     * @see BaseEntity#isNew
     */	
    void saveZone(Zone zone) throws DataAccessException;
    
    /**
     * Retrieve a <code>Way</code> from the data store by id.
     *
     * @param id the id to search for
     * @return the <code>Way</code> if found
     * @throws org.springframework.dao.DataRetrievalFailureException if not found
     */
    Way findWayById(Integer id)  throws DataAccessException;
    
    /**
     * Save a <code>Way</code> to the data store, either inserting or updating it.
     *
     * @param Zone the <code>Way</code> to save
     * @return 
     * @see BaseEntity#isNew
     */	
    Way saveWay(Way Way) throws DataAccessException;
    
   
    /**
     * Save a <code>Part</code> to the data store, either inserting or updating it.
     *
    /**
     * Retrieve a <code>Length</code> from the data store by id.
     *
     * @param id the id to search for
     * @return the <code>Length</code> if found
     * @throws org.springframework.dao.DataRetrievalFailureException if not found
     */
    Length findLengthById(Integer id)  throws DataAccessException;
    
    /**
     * Save a <code>Length</code> to the data store, either inserting or updating it.
     *
     * @param Zone the <code>Length</code> to save
     * @see BaseEntity#isNew
     */	
    void saveLength(Length Length) throws DataAccessException;
    
    /**
     * Retrieve a <code>PoInteger</code> from the data store by id.
     *
     * @param id the id to search for
     * @return the <code>PoInteger</code> if found
     * @throws org.springframework.dao.DataRetrievalFailureException if not found
     */
    Point findPointById(Integer id)  throws DataAccessException;
    
    /**
     * Save a <code>PoInteger</code> to the data store, either inserting or updating it.
     *
     * @param Zone the <code>PoInteger</code> to save
     * @see BaseEntity#isNew
     */	
    void savePoint(Point point) throws DataAccessException;
    
    /**
     * Retrieve a <code>Area</code> from the data store by id.
     *
     * @param id the id to search for
     * @return the <code>Area</code> if found
     * @throws org.springframework.dao.DataRetrievalFailureException if not found
     */
    NamedEntity findAreaById(Integer id)  throws DataAccessException;
    
    /**
     * Save a <code>Area</code> to the data store, either inserting or updating it.
     *
     * @param Zone the <code>Area</code> to save
     * @see BaseEntity#isNew
     */	
    void saveArea(Area area) throws DataAccessException;

	Collection<Area> findSiteByPostalCode(String postalcode)  throws DataAccessException;

	List<Site> findAllSite();


	

	



	

	
}
