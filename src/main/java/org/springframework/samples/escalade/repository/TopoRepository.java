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

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Area;
import org.springframework.samples.escalade.model.BaseEntity;
import org.springframework.samples.escalade.model.Length;
import org.springframework.samples.escalade.model.Point;
import org.springframework.samples.escalade.model.Topo;
import org.springframework.samples.escalade.model.TopoType;
import org.springframework.samples.escalade.model.Way;
import org.springframework.samples.escalade.model.Zone;






/**
 * Repository class for <code>Topo</code> domain objects All method names are compliant with Spring Data naming
 * conventions so this Longerface can easily be extended for Spring Data See here: http://static.springsource.org/spring-data/jpa/docs/current/reference/html/jpa.repositories.html#jpa.query-methods.query-creation
 *
 * @author Ken Krebs
 * @author Juergen Hoeller
 * @author Sam Brannen
 * @author Michael Isvy
 */
public interface TopoRepository {

    /**
     * Retrieve all <code>TopoType</code>s from the data store.
     *
     * @return a <code>Collection</code> of <code>TopoType</code>s
     */
    List<TopoType> findTopoTypes() throws DataAccessException;

    /**
     * Retrieve a <code>Topo</code> from the data store by id.
     *
     * @param id the id to search for
     * @return the <code>Topo</code> if found
     * @throws org.springframework.dao.DataRetrievalFailureException if not found
     */
    Topo findById(Long id) throws DataAccessException;

    /**
     * Save a <code>Topo</code> to the data store, either inserting or updating it.
     *
     * @param Topo the <code>Topo</code> to save
     * @see BaseEntity#isNew
     */
    
    void saveTopo(Topo Topo)  throws DataAccessException;
    
    /**
     * Retrieve a <code>Zone</code> from the data store by id.
     *
     * @param id the id to search for
     * @return the <code>Zone</code> if found
     * @throws org.springframework.dao.DataRetrievalFailureException if not found
     */
    Zone findZoneById(Long id)  throws DataAccessException;
    
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
    Way findWayById(Long id)  throws DataAccessException;
    
    /**
     * Save a <code>Way</code> to the data store, either inserting or updating it.
     *
     * @param Zone the <code>Way</code> to save
     * @see BaseEntity#isNew
     */	
    void saveWay(Way Way) throws DataAccessException;
    
   
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
    Length findLengthById(Long id)  throws DataAccessException;
    
    /**
     * Save a <code>Length</code> to the data store, either inserting or updating it.
     *
     * @param Zone the <code>Length</code> to save
     * @see BaseEntity#isNew
     */	
    void saveLength(Length Length) throws DataAccessException;
    
    /**
     * Retrieve a <code>PoLong</code> from the data store by id.
     *
     * @param id the id to search for
     * @return the <code>PoLong</code> if found
     * @throws org.springframework.dao.DataRetrievalFailureException if not found
     */
    Point findPointById(Long id)  throws DataAccessException;
    
    /**
     * Save a <code>PoLong</code> to the data store, either inserting or updating it.
     *
     * @param Zone the <code>PoLong</code> to save
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
    Area findAreaById(Long id)  throws DataAccessException;
    
    /**
     * Save a <code>Area</code> to the data store, either inserting or updating it.
     *
     * @param Zone the <code>Area</code> to save
     * @see BaseEntity#isNew
     */	
    void saveArea(Area Area) throws DataAccessException;
}
