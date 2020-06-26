package org.springframework.samples.escalade.repository;

import java.util.Collection;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.escalade.model.Topo;
import org.springframework.samples.escalade.model.TopoBkg;
import org.springframework.samples.escalade.model.escaladeException;


public interface TopoBkgRepository  {

	List<TopoBkg> findTopoBkgById(Integer id) throws DataAccessException;

	TopoBkg saveTopoBkg(TopoBkg topoBkg) throws DataAccessException;

	TopoBkg updateTopoBkg(TopoBkg topoBkg) throws escaladeException;

	//Collection<TopoBkg> findTopoBkgByName(String name);

	Boolean checkToposBookedByID(Integer topoId);

	Topo findTopoBookedBytopoBkgId(@NotNull Integer topoBkgId);

	//TopoBkg findOne(Integer id);

	TopoBkg findSingleTopoBkgById(Integer topoBkgId);

	@Query("select topoBkg from TopoBkg topoBkg where (topo) in : topo")
	List<TopoBkg> findByIdinIgnoreCaseIn(@Param("topo") List<String> topo);
	
	@Query("select topoBkg from TopoBkg topoBkg where (topo) in : topo")
	List<TopoBkg> findByIdinIgnoreCaseIn(Topo topo);

	Collection<TopoBkg> findToposBkgs(Integer topo_id);
	
}