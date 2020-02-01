package org.springframework.samples.escalade.repository;

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
    Topo findById(int id) throws DataAccessException;

    /**
     * Save a <code>Topo</code> to the data store, either inserting or updating it.
     *
     * @param Topo the <code>Topo</code> to save
     * @see BaseEntity#isNew
     */
    
    void save(Topo Topo)  throws DataAccessException;
    
    /**
     * Retrieve a <code>Zone</code> from the data store by id.
     *
     * @param id the id to search for
     * @return the <code>Zone</code> if found
     * @throws org.springframework.dao.DataRetrievalFailureException if not found
     */

}
