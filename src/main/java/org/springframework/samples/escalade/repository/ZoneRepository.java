package org.springframework.samples.escalade.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Zone;

public interface ZoneRepository {

	Zone findById(Long id) throws DataAccessException;
	void saveZone(Zone zone)throws DataAccessException;
	

}
