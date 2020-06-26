package org.springframework.samples.escalade.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Way;


public interface WayRepository {
	
	Way findWayById(Integer id) throws DataAccessException;
	
	Way saveWay(Way way) throws DataAccessException;

	Collection<Way> findWayByName(String name);
	
}
