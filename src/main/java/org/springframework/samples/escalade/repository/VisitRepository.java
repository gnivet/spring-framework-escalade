package org.springframework.samples.escalade.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.BaseEntity;
import org.springframework.samples.escalade.model.Visit;

public interface VisitRepository {

    /**
     * Save a <code>Visit</code> to the data store, either inserting or updating it.
     *
     * @param visit the <code>Visit</code> to save
     * @see BaseEntity#isNew
     */
    void save(Visit visit) throws DataAccessException;

    List<Visit> findBySiteId(Integer siteId);

}