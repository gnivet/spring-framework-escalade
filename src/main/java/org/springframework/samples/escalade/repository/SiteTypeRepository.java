package org.springframework.samples.escalade.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.SiteType;

public interface SiteTypeRepository {

	List<SiteType> findSiteTypes() throws DataAccessException;

	

	SiteType findSiteTypeById(Integer id) throws DataAccessException;

	Collection<SiteType> findSiteBySiteType(String name);

	
	
	SiteType saveSiteType(SiteType siteType);



	List<SiteType> findAll();



	Collection<SiteType> getSiteType();



	Collection<SiteType> findSiteTypeByName(String name);



	



}
