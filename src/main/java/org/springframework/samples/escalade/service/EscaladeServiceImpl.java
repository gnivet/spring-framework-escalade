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

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Area;
import org.springframework.samples.escalade.model.Comment;
import org.springframework.samples.escalade.model.SiteType;
import org.springframework.samples.escalade.model.Topo;
import org.springframework.samples.escalade.model.TopoType;
import org.springframework.samples.escalade.model.User;
import org.springframework.samples.escalade.model.Zone;
import org.springframework.samples.escalade.repository.AreaRepository;
import org.springframework.samples.escalade.repository.LengthRepository;
import org.springframework.samples.escalade.repository.PointRepository;
import org.springframework.samples.escalade.repository.TopoRepository;
import org.springframework.samples.escalade.repository.UserRepository;
import org.springframework.samples.escalade.repository.WayRepository;
import org.springframework.samples.escalade.repository.ZoneRepository;
import org.springframework.stereotype.Service;


/**
 * Mostly used as a facade for all escalade controllers Also a placeholder
 * for @Transactional and @Cacheable annotations
 *
 * @author Guillaume Nivet
 * @param <ZoneRepository>
 */

@Service
public class EscaladeServiceImpl  implements EscaladeService {

	@Autowired
	public EscaladeServiceImpl(TopoRepository topoRepository, UserRepository userRepository,
		 AreaRepository areaRepository, ZoneRepository zoneRepository, LengthRepository lengthRepository, PointRepository pointRepository, WayRepository wayRepository) {
	}

	@Override
	public Topo findTopoById(long id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Area findAreaById(long id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveTopo(Topo topo) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<User> findUsers() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Comment> findCommentByName(String name) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveUser(org.springframework.security.core.userdetails.@Valid User user) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveUser(User user) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findUserById(long userId) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<User> findUserByLastName(String lastName) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findLoggedInusername() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void autoLogin(String username, String password) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<User> findUserByusername(String username) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<SiteType> findSiteTypes() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveArea(Area area) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<TopoType> findTopoTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveZone(@Valid Zone zone) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Zone findZoneById(long zoneId) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Zone> findZoneByName(String name) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveComment(@Valid Comment comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Comment findCommentById(long commentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Area> findSiteByPostalCode(String postalcode) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}