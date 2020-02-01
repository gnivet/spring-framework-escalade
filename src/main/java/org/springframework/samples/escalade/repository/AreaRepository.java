package org.springframework.samples.escalade.repository;

import org.springframework.samples.escalade.model.Area;

public interface AreaRepository {

	

	void saveArea(Area area);

	
	Area findAreaById(Integer id);
	
	

}
