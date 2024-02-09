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
package org.springframework.samples.escalade.repository.jpa;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.samples.escalade.model.Area;
import org.springframework.samples.escalade.model.NamedEntity;
import org.springframework.samples.escalade.model.Site;
import org.springframework.samples.escalade.repository.AreaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * JPA implementation of the {@link AreaRepository} Integererface.
 *
 * @author Guillaume Nivet
 * @since 3.12.2019
 */
@Transactional
@Repository
public class JpaAreaRepositoryImpl implements AreaRepository {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public Collection<Area> findTopoByPostalcode(String postalcode) {
		// TODO Auto-generated method stub

		Query query = this.em
				.createQuery("SELECT DISTINCT area from Area area WHERE area.postalcode LIKE '%:postalcode%'");
		query.setParameter("postalcode", "%" + postalcode + "%");
		return query.getResultList();
	}

	public Area findAreaById(Integer id) {
		// using 'join fetch' because a single query should load both areas and topos
		// using 'left join fetch' because it might happen that an owner does not have
		// topos yet

		Query query = this.em.createQuery("SELECT area FROM Area area WHERE area.id =:id");
		query.setParameter("id", id);
		return (Area) query.getSingleResult();
	}

	public Area saveArea(Area area) {

		if (area.getId() == null) {
			this.em.persist(area);
		}

		else {
			this.em.merge(area);
		}
		return area;
	}
//modificaction pour générer une pk sur l'entité site  
	public NamedEntity saveSite(NamedEntity site) {

		if (site.getId() == null) {
			this.em.persist(site);
		}

		else {
			this.em.merge(site);
		}
		return site;
	} 
	
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@SuppressWarnings("unchecked")
	public List<Area> findAll() {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("SELECT area FROM Area area");

		return query.getResultList();
	}

	@Override
	public List<Area> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Site> findAllSite() {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("SELECT site FROM Site site");

		return query.getResultList();

	}

	public NamedEntity updateArea(Area area) {
		if (!this.em.contains(area))
			this.em.merge(area);
		return area;
	}

	
	@SuppressWarnings("unchecked")
	public Collection<Area> findSiteByPostalcode(String postalcode) {
		// TODO Auto-generated method stub

		Query query = this.em.createQuery("select area from Area area WHERE area.postalcode LIKE :postalcode");
		query.setParameter("postalcode", "%" + postalcode + "%");
		return query.getResultList();

	}

	@Override
	public List<Site> sitesList() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Area> listAreas() {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("SELECT area FROM Area area");

		return query.getResultList();
	}

	
	public Area deleteAreaById(Integer areaId) {
	Query query = this.em.createQuery("delete area from Area WHERE area.areaId = :areaId");
	query.setParameter("areaId", "%" + areaId + "%");
	return null;
	}
	
	
	


	

}