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
import org.springframework.samples.escalade.model.Commentaire;
import org.springframework.samples.escalade.model.Length;
import org.springframework.samples.escalade.model.Point;
import org.springframework.samples.escalade.model.SiteType;
import org.springframework.samples.escalade.model.Topo;
import org.springframework.samples.escalade.model.TopoType;
import org.springframework.samples.escalade.model.User;
import org.springframework.samples.escalade.model.Way;
import org.springframework.samples.escalade.model.Zone;
import org.springframework.samples.escalade.repository.AreaRepository;
import org.springframework.samples.escalade.repository.CommentaireRepository;
import org.springframework.samples.escalade.repository.SiteRepository;
import org.springframework.samples.escalade.repository.TopoRepository;
import org.springframework.samples.escalade.repository.UserRepository;
import org.springframework.stereotype.Service;

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
	private AreaRepository areaRepository;
	private CommentaireRepository commentaireRepository;
	private SiteRepository siteRepository;

	@Autowired
	public EscaladeServiceImpl(TopoRepository topoRepository, UserRepository userRepository,
			CommentaireRepository commentaireRepository, AreaRepository areaRepository ) {
		this.topoRepository = topoRepository;
		this.userRepository = userRepository;
		this.areaRepository = areaRepository;
		this.commentaireRepository = commentaireRepository;
		this.siteRepository = siteRepository;
		
		
	}

	
	public Collection<TopoType> findTopoTypes() throws DataAccessException {
		return topoRepository.findTopoTypes();
	}

	

	

	@Override
	@Transactional
	public void saveUser(User User) throws DataAccessException {
		userRepository.save(User);
	}


	public Collection<SiteType> findSiteTypes() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public Collection<User> findUsers() throws DataAccessException {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

		
	

	@Override
	public String findLoggedInusername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void autoLogin(String username, String password) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void saveCommentaire(@Valid Commentaire commentaire) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	
	
	
	

	@Override
	public void saveUser(org.springframework.security.core.userdetails.@Valid User user) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public Collection<Commentaire> findSiteByName(String commentaire) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commentaire findCommentaireById(long commentaireId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<User> findUserByusername(String username) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
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
	public Collection<Area> findTopoByPostalCode(String postalCode) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
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
	public void saveArea(Area area) {
		// TODO Auto-generated method stub
		
	}


}