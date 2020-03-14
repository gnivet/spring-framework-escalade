package org.springframework.samples.escalade.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Way;


public interface WayRepository {
	
	Way findWayById(Integer id) throws DataAccessException;
	
	Way saveWay(Way way) throws DataAccessException;
	
}
