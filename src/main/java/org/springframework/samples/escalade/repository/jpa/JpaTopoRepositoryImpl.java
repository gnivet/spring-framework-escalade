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

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Area;
import org.springframework.samples.escalade.model.Length;
import org.springframework.samples.escalade.model.Part;
import org.springframework.samples.escalade.model.Point;
import org.springframework.samples.escalade.model.Topo;
import org.springframework.samples.escalade.model.TopoType;
import org.springframework.samples.escalade.model.Way;
import org.springframework.samples.escalade.model.Zone;
import org.springframework.samples.escalade.repository.TopoRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA implementation of the {@link TopoRepository} longerface.
 *
 * @author Guillaume Nivet
 * @since 3.12.2019
 */
@Repository
public class JpaTopoRepositoryImpl implements TopoRepository {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<TopoType> findTopoTypes() {
		return this.em.createQuery("SELECT ptype FROM TopoType ptype ORDER BY ptype.name").getResultList();
	}

	public Topo findById(long id) {
		return this.em.find(Topo.class, id);
	}

	public void save(Topo Topo) {
		if (Topo.getId() == null) {
			this.em.persist(Topo);
		} else {
			this.em.merge(Topo);
		}
	}

	public Zone findZoneById(long id) {
		return this.em.find(Zone.class, id);
	}

	// Add Zone to Topo form
	public void saveZone(Zone Zone) throws DataAccessException {
		if (Zone.getId() == null) {
			this.em.persist(Zone);
		} else {
			this.em.merge(Zone);
		}

	}

	public Way findWayById(long id) {
		return this.em.find(Way.class, id);
	}

	// Add Way to Topo form
	public void saveWay(Way Way) throws DataAccessException {
		if (Way.getId() == null) {
			this.em.persist(Way);
		} else {
			this.em.merge(Way);
		}

	}

	public Part findPartById(long id) {
		return this.em.find(Part.class, id);
	}

	// Add Part to Topo form
	public void savePart(Part Part) throws DataAccessException {
		if (Part.getId() == null) {
			this.em.persist(Part);
		} else {
			this.em.merge(Part);
		}

	}

	public Length findLengthById(long id) {
		return this.em.find(Length.class, id);
	}

	// Add Length to Topo form
	public void saveLength(Length Length) throws DataAccessException {
		if (Length.getId() == null) {
			this.em.persist(Length);
		} else {
			this.em.merge(Length);
		}

	}

	public Point findPointById(long id) {
		return this.em.find(Point.class, id);
	}

	// Add Point to Topo form
	public void savePoint(Point Point) throws DataAccessException {
		if (Point.getId() == null) {
			this.em.persist(Point);
		} else {
			this.em.merge(Point);
		}

	}

	public Area findAreaById(long id) {
		return this.em.find(Area.class, id);
	}

	// Add Area to Topo form
	public void saveArea(Area Area) throws DataAccessException {
		if (Area.getId() == null) {
			this.em.persist(Area);
		} else {
			this.em.merge(Area);
		}

	}
}
