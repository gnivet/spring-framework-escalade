package org.springframework.samples.escalade.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Area;
import org.springframework.samples.escalade.model.NamedEntity;
import org.springframework.samples.escalade.model.Site;



public interface AreaRepository  {
	
	
	public Area saveArea(Area area);

	public Area findAreaById(Integer id) throws DataAccessException;

	
	public List<Area> findAll();
	
	public List<Area> findByName(String name);

	public List<Site> sitesList();

	public NamedEntity updateArea(Area area);

	public Collection<Area> findSiteByPostalcode(String postalcode)throws DataAccessException;

	public Collection<Area> listAreas();

	

}
