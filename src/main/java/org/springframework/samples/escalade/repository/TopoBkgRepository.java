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

public interface TopoBkgRepository {

	List<TopoBkg> findTopoBkgById(Integer id) throws DataAccessException;

	TopoBkg saveTopoBkg(TopoBkg topoBkg) throws DataAccessException;

	TopoBkg updateTopoBkg(TopoBkg topoBkg) throws escaladeException;

	Boolean checkToposBookedByID(Integer topoId) throws DataAccessException;

	Topo findTopoBookedBytopoBkgId(@NotNull Integer topoBkgId) throws DataAccessException;

	TopoBkg getAllTopoBkgById(Integer topoBkgId) throws DataAccessException;

	@Query("select topoBkg from TopoBkg topoBkg where (topo) in : topo")
	List<TopoBkg> findByIdinIgnoreCaseIn(@Param("topo") List<String> topo) throws DataAccessException;

	@Query("select topoBkg from TopoBkg topoBkg where (topo) in : topo")
	List<TopoBkg> findByIdinIgnoreCaseIn(Topo topo) throws DataAccessException;

	Collection<TopoBkg> findToposBkgs(Integer topo_id) throws DataAccessException;



	Collection<TopoBkg> findTopoBkgByUserId(Integer userId) throws DataAccessException;

	Collection<TopoBkg> findTopoBkgs() throws DataAccessException;

	Collection<TopoBkg> findTopoBkgByUserName(String userName) throws DataAccessException;

	Collection<TopoBkg> findTopoBkgByName(String name)throws DataAccessException;

}