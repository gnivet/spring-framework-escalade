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

import org.springframework.samples.escalade.model.Area;
import org.springframework.samples.escalade.repository.AreaRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA implementation of the {@link AreaRepository} Integererface.
 *
 * @author Guillaume Nivet
 * @since 3.12.2019
 */
@Repository
public class JpaAreaRepositoryImpl implements AreaRepository {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public Collection<Area> findTopoByPostalcode(String postalcode) {
		// TODO Auto-generated method stub

		Query query = this.em.createQuery("SELECT DISTINCT area from Area area WHERE area.postalcode LIKE :postalcode");
		query.setParameter("postalcode", postalcode + "%");
		return query.getResultList();
	}

	@Override
	public Area findAreaById(Integer id) {
		// using 'join fetch' because a single query should load both areas and topos
		// using 'left join fetch' because it might happen that an owner does not have
		// topos yet

		Query query = this.em.createQuery("SELECT area FROM Area area WHERE area.id =:id");
		query.setParameter("id", id);
		return (Area) query.getSingleResult();
	}

	public void saveArea(Area area) {
		
		if (area.getId() == null) {
			this.em.persist(area);
		} else {
			this.em.merge(area);
		}
		
	}

	@Override
	public Collection<Area> findSiteByPostalcode(String postalcode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Area> findAll() {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("SELECT area FROM Area area");
		
		return  query.getResultList();
	}

	

	

}