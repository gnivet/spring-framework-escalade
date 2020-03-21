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

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Simple business object representing a site.
 *
 * @author Guillaume Nivet
 */

@Entity
@Table(name = "sites")
public class Site extends NamedEntity {
	
	
	
	@Column(name = "birth_date")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate birthDate;

	@ManyToOne
	@JoinColumn(name = "type_id")
	private SiteType sitetype;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = true)
	private User user;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "area_id", nullable = true)
	private Area area;
	
	

	@Column(name = "valid")
	@NotNull
	private boolean valid;

	@OneToMany(mappedBy = "site")
	private Set<Zone> zone;
	
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
		return sitetype;
	}

	public void setType(SiteType sitetype) {
		this.sitetype = sitetype;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

		public Set<Zone> getZone() {
		return zone;
	}

	public void setZone(Set<Zone> zone) {
		this.zone = zone;
	}

	public SiteType getSitetype() {
		return sitetype;
	}

	public void setSitetype(SiteType sitetype) {
		this.sitetype = sitetype;
	}

	/**
	 * 
	 */
	public Site() {
	}

	/**
	 * @param birthDate
	 * @param sitetype
	 * @param user
	 * @param area
	 * @param valid
	 * @param zone
	 */
public Site(LocalDate birthDate, SiteType sitetype, User user, Area area, @NotNull boolean valid, Set<Zone> zone) {
		this.birthDate = birthDate;
		this.sitetype = sitetype;
		this.user = user;
		this.area = area;
		this.valid = valid;
		this.zone = zone;
	}
	/*
	public void setSite(Site site) {
		// TODO Auto-generated method stub
		this.site = site;
	}
	*/

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
	
	
	
}