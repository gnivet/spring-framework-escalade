package org.springframework.samples.escalade.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.samples.escalade.model.BaseEntity;
import org.springframework.samples.escalade.model.Topo;
import org.springframework.stereotype.Repository;

@Repository
public interface TopoRepository {
	
	@Query("Select topo, user from Topo topo join fetch User user on topo.user_id = user.user.id where user.userName like :userName ")
	//List<Topo> findTopoByUserName();
	


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

	Collection<Topo> findTopoByName()throws DataAccessException;

	Collection<Topo> findTopoAvailableByName()throws DataAccessException;

	List<Topo> findTopoByUserName(String userName)throws DataAccessException;

	List<Topo> findTopoByUserId(Integer id)throws DataAccessException;

	Topo findTopoByNames(String name)throws DataAccessException;

	Collection<Topo> findTopoAvailableByUserId(Integer id) throws DataAccessException;

	
	
    
    /**
     * Retrieve a <code>Zone</code> from the data store by id.
     *
     * @param id the id to search for
     * @return the <code>Zone</code> if found
     * @throws org.springframework.dao.DataRetrievalFailureException if not found
     */

}
