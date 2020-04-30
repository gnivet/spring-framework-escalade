package org.springframework.samples.escalade.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.BaseEntity;
import org.springframework.samples.escalade.model.Topo;


public interface TopoRepository {
	
	/*
	 * Retrieve a <code>Topo</code> from the data store by id.
     *
     * @param id the id to search for
     * @return the <code>Topo</code> if found
     * @throws org.springframework.dao.DataRetrievalFailureException if not found
     */
    Topo findTopoById(int id) throws DataAccessException;

    /**
     * Save a <code>Topo</code> to the data store, either inserting or updating it.
     *
     * @param Topo the <code>Topo</code> to save
     * @see BaseEntity#isNew
     */
    
   Topo saveTopo(Topo Topo)  throws DataAccessException;

	Topo updateTopo(Topo topo)throws DataAccessException;

	Collection<Topo> findTopoByName(String name)throws DataAccessException;

   
    
    /**
     * Retrieve a <code>Zone</code> from the data store by id.
     *
     * @param id the id to search for
     * @return the <code>Zone</code> if found
     * @throws org.springframework.dao.DataRetrievalFailureException if not found
     */

}
