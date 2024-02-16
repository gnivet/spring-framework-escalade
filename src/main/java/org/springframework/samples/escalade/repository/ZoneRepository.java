package org.springframework.samples.escalade.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.NamedEntity;
import org.springframework.samples.escalade.model.Zone;

public interface ZoneRepository {

	Zone findZoneById(Integer id) throws DataAccessException;

	Zone saveZone(Zone zone)throws DataAccessException;

	Collection<Zone> findZoneByName(String name)throws DataAccessException;

	Collection<Zone> findZoneByNames(String name)throws DataAccessException;

	NamedEntity updateZone(Zone zone);

	Collection<Zone> findZones() throws DataAccessException;

	Collection<Zone> findZoneBySiteName(String name)throws DataAccessException;

	Collection<Zone> findZoneByNames() throws DataAccessException;



}
