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
package org.springframework.samples.escalade.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

//import javax.persistence.Id;

/**
 * Simple business object representing a Area.
 *
 * @author Guillaume Nivet
 * @author Guillaume Nivet
 * @author Guillaume Nivet
 */

@Entity
@Table(name = "areas")
public class Area extends NamedEntity {

	@ManyToOne
	@JoinColumn(name = "type_id")
	private AreaType type;

	public AreaType getType() {
		return this.type;
	}

	public void setType(AreaType type) {
		this.type = type;
	}

	@Column(name = "street")
	private String street;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Column(name = "postalcode")
	private String postalcode;

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	@Column(name = "city")
	private String city;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "country")
	private String country;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "gpscoordinate")
	private String gpscoordinate;

	public String getGpscoordinate() {

		return gpscoordinate;
	}

	public void setGpscoordinate(String gpscoordinate) {
		this.gpscoordinate = gpscoordinate;
	}

	// GNI
	// @OneToMany(cascade = CascadeType.ALL, mappedBy = "area")
	// private Set<Topo> topos;

	// @OneToMany
	// @JoinColumn(name = "topos")

	@ManyToOne
	@JoinColumn(name = "topo_id", nullable = true)
	private Topo topo;

	public Topo getTopo() {
		return topo;
	}

	public void setTopo(Topo topo) {
		this.topo = topo;
	}

	@Column(name = "topos")
	private String topos;

	public String getTopos() {
		return topos;
	}

	public void setTopos(String topos) {
		this.topos = topos;
	}

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = true)
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "topo", fetch = FetchType.LAZY)
	private Set<Visit> visits;

	protected Set<Visit> getVisitsInternal() {
		if (this.visits == null) {
			this.visits = new HashSet<>();
		}
		return this.visits;
	}

	protected void setVisitsInternal(Set<Visit> visits) {
		this.visits = visits;
	}

	public List<Visit> getVisits() {
		List<Visit> sortedVisits = new ArrayList<>(getVisitsInternal());
		PropertyComparator.sort(sortedVisits, new MutableSortDefinition("date", false, false));
		return Collections.unmodifiableList(sortedVisits);
	}

	// public void addVisit(Visit visit) {
	// getVisitsInternal().add(visit);
	// visit.setArea(this);

	// }

	public void setVisits(Set<Visit> visits) {
		this.visits = visits;
	}

}
