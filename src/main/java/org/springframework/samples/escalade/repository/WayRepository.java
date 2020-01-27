package org.springframework.samples.escalade.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Way;

public interface WayRepository {

	Way findById(Long id) throws DataAccessException;

	void saveWay(Way way) throws DataAccessException;

}
