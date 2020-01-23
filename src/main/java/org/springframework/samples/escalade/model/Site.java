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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Simple business object representing a Topo.
 *
 * @author Guillaume Nivet
 */

@Entity
@Table(name = "sites")
public class Site extends NamedEntity {
	
	
	//@Column(name = "site_id", nullable = false)
	//private Long site_id;

	@Column(name = "birth_date")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate birthDate;

	@ManyToOne
	@JoinColumn(name = "type_id")

	private SiteType type;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "area_id", nullable = true)
	private Area area;

	@Transient
	@Column(name = "length_status")
	@NotNull
	private boolean length_status;

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

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public LocalDate getBirthDate() {
		return this.birthDate;
	}

	public SiteType getType() {
		return this.type;
	}

	public void setType(SiteType type) {
		this.type = type;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isLength_status() {
		return length_status;
	}

	public void setLength_status(boolean length_status) {
		this.length_status = length_status;
	}

	public String toString() {
		return "TopoType [type=" + type + "]";
	}

	public Set<Zone> getZone() {
		return zone;
	}

	public void setZone(Set<Zone> zone) {
		this.zone = zone;
	}
	/*
	public Long getSite_id() {
		return site_id;
	}

	public void setSite_id(Long site_id) {
		this.site_id = site_id;
	}
	*/
	@ManyToOne
	@JoinColumn(name = "site_id", nullable = true)
	private Commentaire commentaire;

	public Commentaire getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(Commentaire commentaire) {
		this.commentaire = commentaire;
	}
	
	
}