package org.springframework.samples.escalade.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.SiteType;

public interface SiteTypeRepository {

	public List<SiteType> findSiteTypes() throws DataAccessException;

	

	public SiteType findSiteTypeById(Integer id) throws DataAccessException;

	public Collection<SiteType> findSiteBySiteType(String name)throws DataAccessException;

	
	
	public SiteType saveSiteType(SiteType siteType)throws DataAccessException;



	public List<SiteType> findAll()throws DataAccessException;



	public Collection<SiteType> getSiteType()throws DataAccessException;



	public Collection<SiteType> findSiteTypeByName(String name)throws DataAccessException;



	



}
