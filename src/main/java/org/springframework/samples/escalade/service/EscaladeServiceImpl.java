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

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Area;
import org.springframework.samples.escalade.model.Comment;
import org.springframework.samples.escalade.model.Site;
import org.springframework.samples.escalade.model.SiteType;
import org.springframework.samples.escalade.model.Topo;
import org.springframework.samples.escalade.model.Zone;
import org.springframework.samples.escalade.repository.AreaRepository;
import org.springframework.samples.escalade.repository.CommentRepository;
import org.springframework.samples.escalade.repository.SiteRepository;
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
	
	@Autowired
	private AreaRepository areaRepository;
	@Autowired
	private CommentRepository commentRepository;
	
	private ZoneRepository zoneRepository;
	
	private SiteRepository siteRepository;
	
	
	@Autowired
	public EscaladeServiceImpl
	(
			
			 AreaRepository areaRepository,
			 CommentRepository commentRepository,
			 ZoneRepository zoneRepository,
			 SiteRepository siteRepository
			
	)
	{
		this.areaRepository = areaRepository;
		this.commentRepository = commentRepository;
		this.zoneRepository = zoneRepository;
		this.siteRepository = siteRepository;
		
	}

	

	
	public Area findAreaById(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return areaRepository.findAreaById(id);
	}

	
	public Comment findCommentById(Integer id) throws DataAccessException{
		return commentRepository.findCommentById(id);
	}
//Comment findCommentById(Integer commentId)throws DataAccessException;
	
	public Collection<Comment> findCommentByName(String name) throws DataAccessException {
		// TODO Auto-generated method stub
		return commentRepository.findCommentByName(name);
	}
	
	
	public void saveComment(Comment comment) throws DataAccessException {
		
		commentRepository.saveComment(comment);
		
	}
	
	
	

	
	
	
	
	
	
	
	
	
	public Topo findTopoById(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public void saveTopo(Topo topo) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	

	

	
	public String findLoggedInusername() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void autoLogin(String username, String password) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	
	public Collection<SiteType> findSiteTypes() throws DataAccessException {
		// TODO Auto-generated method stub
		return siteRepository.findSiteTypes();
	}

	
	
	public void saveArea(Area area) throws DataAccessException {
		
		areaRepository.saveArea(area);
	}

	
	public void saveZone(Zone zone) throws DataAccessException {
		// TODO Auto-generated method stub
		zoneRepository.saveZone(zone);
		
	}

	
	public Zone findZoneById(Integer zoneId) throws DataAccessException {
		// TODO Auto-generated method stub
		return zoneRepository.findZoneById(zoneId);
	}

	
	public Collection<Zone> findZoneByName(String name) throws DataAccessException {
		// TODO Auto-generated method stub
		return zoneRepository.findZoneByName(name);
	}

	

	

	@Transactional
	public Collection<Area> findSiteByPostalCode(String postalcode) {
		// TODO Auto-generated method stub
		return areaRepository.findSiteByPostalcode(postalcode);
	}
	
	
	

	@Transactional
	public void saveSite(Site site) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public Site findSiteById(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
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

	
	

		
}