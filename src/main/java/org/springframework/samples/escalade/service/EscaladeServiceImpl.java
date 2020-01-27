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
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Area;
import org.springframework.samples.escalade.model.Length;
import org.springframework.samples.escalade.model.Point;
import org.springframework.samples.escalade.model.SiteType;
import org.springframework.samples.escalade.model.Topo;
import org.springframework.samples.escalade.model.TopoType;
import org.springframework.samples.escalade.model.User;
import org.springframework.samples.escalade.model.Way;
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

	private TopoRepository topoRepository;
	private UserRepository userRepository;
	private AreaRepository areaRepository;
	private ZoneRepository zoneRepository;
	private LengthRepository lengthRepository;
	private PointRepository pointRepository;
	private WayRepository wayRepository;


	@Autowired
	public EscaladeServiceImpl(TopoRepository topoRepository, UserRepository userRepository,
		 AreaRepository areaRepository, ZoneRepository zoneRepository, LengthRepository lengthRepository, PointRepository pointRepository, WayRepository wayRepository) {
		this.topoRepository = topoRepository;
		this.userRepository = userRepository;
		this.areaRepository = areaRepository;
		this.zoneRepository = zoneRepository;
		this.lengthRepository = lengthRepository;
		this.pointRepository = pointRepository;
		this.wayRepository = wayRepository;
	}


	public Topo findTopoById(Long id) throws DataAccessException {
		return topoRepository.findById(id);
	}

	public Way findWayById(Long id) throws DataAccessException {
		return wayRepository.findById(id);
	}

	
	public Area findAreaById(Long id) throws DataAccessException {
		return areaRepository.findById(id);
	}


	public void saveTopo(Topo Topo) throws DataAccessException {
		topoRepository.saveTopo(Topo);
	}

	
	@Transactional
	public void saveZone(Zone Zone) throws DataAccessException {
		zoneRepository.saveZone(Zone);
	}

	@Transactional
	public void saveWay(Way Way) throws DataAccessException {
		topoRepository.saveWay(Way);
	}

	
	@Transactional
	public void saveLength(Length Length) throws DataAccessException {
		lengthRepository.saveLength(Length);
	}

	@Transactional
	public void savePoint(Point Point) throws DataAccessException {
		pointRepository.savePoint(Point);
	}

	@Transactional
	public void saveArea(Area Area) throws DataAccessException {
		areaRepository.saveArea(Area);
	}
	
	
	@Override
	public Collection<User> findUsers() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Collection<Area> findTopoByPostalCode(String postalCode) throws DataAccessException {
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
		return userRepository.findById(userId);
	}

	@Override
	public Topo findTopoById(long id) throws DataAccessException {
		// TODO Auto-generated method stub
		return topoRepository.findById(id);
	}



	@Override
	public Area findAreaById(long id) throws DataAccessException {
		// TODO Auto-generated method stub
		return areaRepository.findById(id);
	}
	
	public Zone findZoneById(Long id) throws DataAccessException {
		return zoneRepository.findById(id);
	}
	
	
	public Length findLengthById(Long id) throws DataAccessException {
		return lengthRepository.findById(id);
	}
	
	public Point findPointById(Long id) throws DataAccessException {
	
		return pointRepository.findById(id);
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
	public Collection<TopoType> findTopoTypes() {
		// TODO Auto-generated method stub
		return null;
	}




	
	


	
	
}