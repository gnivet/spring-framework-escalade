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

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Simple business object representing a site.
 *
 * @author Guillaume Nivet
 */

@Entity
@Table(name = "sites")
public class Site extends NamedEntity {
	
	//@Id
    //@GeneratedValue
    //private int id;
	
	@Column(name = "birthDate")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate birthDate;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)	
	@JoinColumn(name = "type_id")
	private SiteType type;

	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)	
	@JoinColumn(name = "user_id", nullable = true)
	private User user;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "area_id", nullable = true)
	private Area area;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)	
	@JoinColumn(name = "site_id", nullable = true)
	private Site site;
	
	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}


	@Column(name = "valid")
	@NotNull
	private boolean valid;
	
	
	//@OneToMany(targetEntity = Zone.class,  fetch=FetchType.EAGER)
	//@JoinColumn(name = "zone_id", nullable = true)
	//private Set<Zone> zones = new HashSet<Zone>();
	// https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/
	
	@Autowired
	@OneToMany(mappedBy = "site", 
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	)	
	// private List zones = new ArrayList<>();
	 private Set<Zone> zones = new HashSet<Zone>();
	 
	 public void addZone(Zone zone) {
	        zones.add(zone);
	        zone.setSite(this);
	    }
	 
	    public void removeZone(Zone zone) {
	        zones.remove(zone);
	        zone.setSite(null);
	    } 
	
	
	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	

	
	
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public LocalDate getBirthDate() {
		return this.birthDate;
	}
	
	
	


	public SiteType getType() {
		return type;
	}

	public void setType(SiteType type) {
		this.type = type;
	}

	public User getUser() {
		return user;
	}

	
	
	

	public Set<Zone> getZones() {
		return zones;
	}

	public void setZones(Set<Zone> zones) {
		this.zones = zones;
	}

	
	
	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
	/**
	 * 
	 */
	public Site() {
	}

	
	

	public void addVisit(Visit visit) {
		// TODO Auto-generated method stub
		
		
	}

	public Object getVisits() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setArea(Site site) {
		// TODO Auto-generated method stub
		
	}


	public void setUser(User user) {
		// TODO Auto-generated method stub
		this.user = user;
	}


	
	




	
	

	
	
	
}