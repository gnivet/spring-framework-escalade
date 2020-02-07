package org.springframework.samples.escalade.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Area;

public interface areaRepository {

	
 
	void saveArea(Area area);

	
	Area findAreaById(Integer id) throws DataAccessException;


	Collection<Area> findSiteByPostalcode(String postalcode)throws DataAccessException;
	
	
	
}
