package org.springframework.samples.escalade.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Zone;

public interface ZoneRepository {
	
	Zone findZoneById(Integer zoneId) throws DataAccessException;
	void saveZone(Zone zone)throws DataAccessException;
	Collection<Zone> findZoneByName(String name)throws DataAccessException;
	

}
