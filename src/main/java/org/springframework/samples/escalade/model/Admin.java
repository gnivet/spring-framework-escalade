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

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

/**
 * Simple JavaBean domain object representing a user.
 *
 * @author Guillaume Nivet
 * @author Guillaume Nivet
 * @author Guillaume Nivet
 * @author Guillaume Nivet
 */

@Entity
@Table(name = "admins")
public class Admin extends Person {

	/*
	 * 
	 */

	@Column(name = "address")
	@NotEmpty
	private String address;

	@Column(name = "postalcode")
	@NotEmpty
	private String postalcode;

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Area> areas;

	@Column(name = "city")
	@NotEmpty
	private String city;

	@Column(name = "telephone")
	@NotEmpty
	@Digits(fraction = 0, integer = 10)
	private String telephone;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Topo> topos;

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "username")
	protected String username;

	public String getAdminname() {
		return this.username;
	}

	public void setAdminname(String username) {
		this.username = username;
	}

	@Column(name = "password")
	protected String password;

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Holds value of property roles. FOREIGN KEY (role_id)
	 */

	@ManyToOne
	@JoinColumn(name = "role_id", nullable = true)
	private Role role;
	/*
	 * @ManyToMany(fetch = FetchType.EAGER)
	 * 
	 * @JoinTable(name = "user_specialties", joinColumns = @JoinColumn(name =
	 * "user_id"), inverseJoinColumns = @JoinColumn(name = "specialty_id")) private
	 * Set<Specialty> specialties;
	 * 
	 * protected Set<Specialty> getSpecialtiesInternal() { if (this.specialties ==
	 * null) { this.specialties = new HashSet<>(); } return this.specialties; }
	 * 
	 * protected void setSpecialtiesInternal(Set<Specialty> specialties) {
	 * this.specialties = specialties; }
	 * 
	 * @XmlElement public List<Specialty> getSpecialties() { List<Specialty>
	 * sortedSpecs = new ArrayList<>(getSpecialtiesInternal());
	 * PropertyComparator.sort(sortedSpecs, new MutableSortDefinition("name", true,
	 * true)); return Collections.unmodifiableList(sortedSpecs); }
	 * 
	 * public int getNrOfSpecialties() { return getSpecialtiesInternal().size(); }
	 * 
	 * public void addSpecialty(Specialty specialty) {
	 * getSpecialtiesInternal().add(specialty); }
	 * 
	 */

}
