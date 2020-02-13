package org.springframework.samples.escalade.repository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Zone;

public interface ZoneRepository {
	@Autowired
	Zone findZoneById(Integer id) throws DataAccessException;	
	@Autowired
	void saveZone(Zone zone)throws DataAccessException;
	@Autowired
	Collection<Zone> findZoneByName(String name)throws DataAccessException;
	

}
