package org.springframework.samples.escalade.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Point;

public interface PointRepository {

	Point findById(Long id) throws DataAccessException;
	void savePoint(Point point)throws DataAccessException;
}
