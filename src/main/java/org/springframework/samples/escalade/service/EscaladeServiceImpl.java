/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.escalade.service;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Area;
import org.springframework.samples.escalade.model.Comment;
import org.springframework.samples.escalade.model.NamedEntity;
import org.springframework.samples.escalade.model.Site;
import org.springframework.samples.escalade.model.SiteType;
import org.springframework.samples.escalade.model.Topo;
import org.springframework.samples.escalade.model.Way;
import org.springframework.samples.escalade.model.Zone;
import org.springframework.samples.escalade.repository.AreaRepository;
import org.springframework.samples.escalade.repository.CommentRepository;
import org.springframework.samples.escalade.repository.SiteRepository;
import org.springframework.samples.escalade.repository.SiteTypeRepository;
import org.springframework.samples.escalade.repository.WayRepository;
import org.springframework.samples.escalade.repository.ZoneRepository;
import org.springframework.stereotype.Service;
/**
 * Mostly used as a facade for all escalade controllers Also a placeholder
 * for @Transactional and @Cacheable annotations
 *
 * @author Guillaume Nivet
 * 
 */

@Service
public class EscaladeServiceImpl implements EscaladeService {
	
	
	private AreaRepository areaRepository;
	
	private CommentRepository commentRepository;
	
	private ZoneRepository zoneRepository;
	
	private SiteRepository siteRepository;
	private SiteTypeRepository siteTypeRepository;

	private WayRepository wayRepository;
	
	@Autowired
	public EscaladeServiceImpl(

			AreaRepository areaRepository, CommentRepository commentRepository, ZoneRepository zoneRepository,
			SiteRepository siteRepository, SiteTypeRepository siteTypeRepository, WayRepository wayRepository)

	{
		this.areaRepository = areaRepository;
		this.commentRepository = commentRepository;
		this.zoneRepository = zoneRepository;
		this.siteRepository = siteRepository;
		this.siteTypeRepository = siteTypeRepository;
		this.wayRepository = wayRepository;

	}

	

	

	@Transactional
	public Comment findCommentById(Integer id) throws DataAccessException{
		return commentRepository.findCommentById(id);
	}
//Comment findCommentById(Integer commentId)throws DataAccessException;
	@Transactional
	public Collection<Comment> findCommentByName(String name) throws DataAccessException {
		// TODO Auto-generated method stub
		return commentRepository.findCommentByName(name);
	}
	
	@Transactional
	public void saveComment(Comment comment) throws DataAccessException {
		
		commentRepository.saveComment(comment);
		
	}
	
	
	

	
	
	
	
	
	
	
	
	@Transactional
	public Topo findTopoById(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	public void saveTopo(Topo topo) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	

	

	@Transactional
	public String findLoggedInusername() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public void autoLogin(String username, String password) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public Collection<SiteType> findSiteTypes() throws DataAccessException {
		// TODO Auto-generated method stub
		return siteRepository.findSiteTypes();
	}

	
	@Transactional
	public Area saveArea(Area area) throws DataAccessException {
		
		return areaRepository.saveArea(area);
	}
	
	

	
	

	
	
	
	@Override
	@Transactional
	public NamedEntity updateArea(Area area) {
		return areaRepository.updateArea(area);
		
	}
	

	

	@Transactional
	public Zone saveZone(Zone zone) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.zoneRepository.saveZone(zone);
		
	}
	
	@Transactional
	public Zone findZoneById(Integer zoneId) throws DataAccessException {
		// TODO Auto-generated method stub
		return zoneRepository.findZoneById(zoneId);
	}

	@Transactional
	public Collection<Zone> findZoneByName(String name) throws DataAccessException {
		// TODO Auto-generated method stub
		return zoneRepository.findZoneByName(name);
	}

	

	
	
	

	

	@Transactional
	public Site findSiteById(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return siteRepository.findSiteById(id);
	}

	@Transactional
	public Area findAreaById(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return areaRepository.findAreaById(id);
	}
	


	@Transactional
	public org.springframework.samples.escalade.model.User findUserByID(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	public Collection<User> findUsers() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Collection<SiteType> findSiteTypesCollection() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	@Transactional
	public List<SiteType> findSiteTypesList() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	
	


	@Override
	@Transactional
	public void save(SiteType siteType) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}




	@Override
	@Transactional
	public SiteType findById(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return siteTypeRepository.findById(id);
	}

	@Transactional
	public Way findWayById(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return wayRepository.findWayById(id);
	}

	

	@Override
	@Transactional
	public Collection<SiteType> findSiteBySiteType(String name) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	@Transactional
	public SiteType findSiteTypeById(Integer siteTypeId) {
		// TODO Auto-generated method stub
		return siteTypeRepository.findById(siteTypeId);
	}




	@Override
	@Transactional
	public SiteType saveSiteType(SiteType siteType) {
		// TODO Auto-generated method stub
		return this.siteTypeRepository.saveSiteType(siteType);
	}

	
	

	@Transactional
	public Way saveway(Way way) {
		// TODO Auto-generated method stub
		return this.wayRepository.saveWay(way);
	}




	@Transactional
	public Collection<Way> findWayByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	public Way finWayById(Integer wayId) {
		return wayRepository.findWayById(wayId);
	}
	
	

	@Override
	@Transactional
	public Site findSiteOwnedbyUser(String userName ) throws DataAccessException {
		// TODO Auto-generated method stub
		Integer id = null;
		return siteRepository.findSiteById(id);
	}

		

	
	@Transactional
	public Collection<Area> findSiteByPostalCode(String postalcode) throws DataAccessException {
		// TODO Auto-generated method stub
		return areaRepository.findSiteByPostalcode(postalcode);
	}





	@Override
	public Site saveSite(Site site) throws DataAccessException {
		// TODO Auto-generated method stub
		return siteRepository.saveSite(site);
	}





	




	
		
}