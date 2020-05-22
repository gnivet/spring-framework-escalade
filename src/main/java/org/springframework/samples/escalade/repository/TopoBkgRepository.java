package org.springframework.samples.escalade.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.TopoBkg;


public interface TopoBkgRepository {

	TopoBkg findTopoBkgById(Integer id) throws DataAccessException;

	TopoBkg saveTopoBkg(TopoBkg topoBkg) throws DataAccessException;

	TopoBkg updateTopoBkg(TopoBkg topoBkg);

	Collection<TopoBkg> findTopoBkgByName(String name);

	String checkToposBookedByID(Integer id);

}
