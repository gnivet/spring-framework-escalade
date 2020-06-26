package org.springframework.samples.escalade.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Point;

public interface PointRepository {

	Point findById(Integer id) throws DataAccessException;
	Point savePoints(Point point)throws DataAccessException;
	Point findPointById(Integer pointId)throws DataAccessException;
	Collection<Point> findPointByName(String name);
}
