package org.springframework.samples.escalade.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.escalade.model.Area;
import org.springframework.samples.escalade.model.Site;

//public interface AreaRepository extends CrudRepository<Area, Integer>{
public interface AreaRepository  {
	
	//@Query("SELECT DISTINCT area FROM Area area left join fetch area.sites WHERE area.postalcode LIKE :postalcode%")
	@Query("SELECT DISTINCT area FROM Area area left join fetch area.sites WHERE area.postalcode LIKE :postalcode%")
	public Collection<Area> findSiteByPostalCode(@Param("postalcode") String postalcode);

	//@Query("SELECT area FROM Area area left join fetch area.sites WHERE area.id =:id")
	@Query("SELECT area FROM Area area left join fetch area.sites WHERE area.id =:id")
	public Area findById(@Param("id") int id);

	public Area saveArea(Area area);

	public Area findAreaById(Integer id) throws DataAccessException;

	public Collection<Area> findSiteByPostalcode(String postalcode) throws DataAccessException;

	public List<Area> findAll();

	public List<Area> findByName(String name);

	public List<Site> sitesList();

}
