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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Area;
import org.springframework.samples.escalade.model.AreaType;
import org.springframework.samples.escalade.model.Length;
import org.springframework.samples.escalade.model.Part;
import org.springframework.samples.escalade.model.Point;
import org.springframework.samples.escalade.model.Topo;
import org.springframework.samples.escalade.model.TopoType;
import org.springframework.samples.escalade.model.User;
import org.springframework.samples.escalade.model.Visit;
import org.springframework.samples.escalade.model.Way;
import org.springframework.samples.escalade.model.Zone;
import org.springframework.samples.escalade.repository.AreaRepository;
import org.springframework.samples.escalade.repository.TopoRepository;
import org.springframework.samples.escalade.repository.UserRepository;
import org.springframework.samples.escalade.repository.VisitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Mostly used as a facade for all escalade controllers Also a placeholder
 * for @Transactional and @Cacheable annotations
 *
 * @author Guillaume Nivet
 */
@Service
public class EscaladeServiceImpl implements EscaladeService {

	private TopoRepository topoRepository;
	private UserRepository userRepository;

	private VisitRepository visitRepository;
	private AreaRepository areaRepository;

	@Autowired
	public EscaladeServiceImpl(TopoRepository topoRepository, UserRepository userRepository,
			VisitRepository visitRepository, AreaRepository areaRepository) {
		this.topoRepository = topoRepository;
		this.userRepository = userRepository;
		this.visitRepository = visitRepository;
		this.areaRepository = areaRepository;
	}

	@Transactional(readOnly = true)
	public Collection<TopoType> findTopoTypes() throws DataAccessException {
		return topoRepository.findTopoTypes();
	}

	@Transactional(readOnly = true)
	public User findUserById(long id) throws DataAccessException {
		return userRepository.findById(id);
	}

	@Transactional
	public void saveVisit(Visit visit) throws DataAccessException {
		visitRepository.save(visit);
	}

	@Transactional(readOnly = true)
	public Topo findTopoById(long id) throws DataAccessException {
		return topoRepository.findById(id);
	}

	@Transactional
	public void saveTopo(Topo Topo) throws DataAccessException {
		topoRepository.save(Topo);
	}

	@Transactional
	public void saveZone(Zone Zone) throws DataAccessException {
		topoRepository.saveZone(Zone);
	}

	@Transactional
	public void saveWay(Way Way) throws DataAccessException {
		topoRepository.saveWay(Way);
	}

	@Transactional
	public void savePart(Part Part) throws DataAccessException {
		topoRepository.savePart(Part);
	}

	@Transactional
	public void saveLength(Length Length) throws DataAccessException {
		topoRepository.saveLength(Length);
	}

	@Transactional
	public void savePoint(Point Point) throws DataAccessException {
		topoRepository.savePoint(Point);
	}

	@Transactional
	public void saveArea(Area Area) throws DataAccessException {
		topoRepository.saveArea(Area);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<User> findUserByLastName(String lastName) throws DataAccessException {
		return userRepository.findByLastName(lastName);
	}

	@Override
	@Transactional
	public void saveUser(User User) throws DataAccessException {
		userRepository.save(User);
	}

	public Collection<Visit> findVisitsByTopoId(long TopoId) {
		return visitRepository.findByTopoId(TopoId);
	}

	@Override
	public Collection<Visit> findVisitsByAreaId(long AreaId) {
		// TODO Auto-generated method stub
		return visitRepository.findByAreaId(AreaId);
	}

	public Collection<AreaType> findAreaTypes() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(readOnly = true)
	public Area findAreaById(long id) throws DataAccessException {
		return areaRepository.findById(id);
	}

	@Transactional(readOnly = true)
	public Collection<Area> findTopoByPostalCode(String postalcode) throws DataAccessException {
		return areaRepository.findTopoByPostalcode(postalcode);
	}

	@Override
	public Collection<User> findUsers() throws DataAccessException {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

}