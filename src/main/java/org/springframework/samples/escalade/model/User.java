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
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

/**
 * Simple JavaBean domain object representing a user.
 * 
 * @author Guillaume Nivet
 */

@Entity
@Table(name = "users")
public class User extends Person {

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

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
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

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", nullable = true)
	private Role role;

	/**
	 * Holds value of property roles. FOREIGN KEY (specialty_id)
	 */

	/*
	 * @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "specialty_id", nullable = true)
	 */

	/**
	 * Holds value of property roles. FOREIGN KEY (specialty_id)
	 */

	@Column(name = "valid")
	private boolean valid;

	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	protected Set<Topo> getToposInternal() {
		if (this.topos == null) {
			this.topos = new HashSet<>();
		}
		return this.topos;
	}

	protected void setToposInternal(Set<Topo> topos) {
		this.topos = topos;
	}

	public List<Topo> getTopos() {
		List<Topo> sortedTopos = new ArrayList<>(getToposInternal());
		PropertyComparator.sort(sortedTopos, new MutableSortDefinition("name", true, true));
		return Collections.unmodifiableList(sortedTopos);
	}

	public void addTopo(Topo topo) {
		getToposInternal().add(topo);
		topo.setUser(this);
	}

	/**
	 * Return the Topo with the given name, or null if none found for this User.
	 *
	 * @param name to test
	 * @return true if topo name is already in use
	 */
	public Topo getTopo(String name) {
		return getTopo(name, false);
	}

	/**
	 * Return the Topo with the given name, or null if none found for this User.
	 *
	 * @param name to test
	 * @return true if topo name is already in use
	 */
	public Topo getTopo(String name, boolean ignoreNew) {
		name = name.toLowerCase();
		for (Topo topo : getToposInternal()) {
			if (!ignoreNew || !topo.isNew()) {
				String compName = topo.getName();
				compName = compName.toLowerCase();
				if (compName.equals(name)) {
					return topo;
				}
			}
		}
		return null;
	}

	/**
	 * /* Constructor Return firstname with Capitalize at the first Letter*
	 * 
	 * @param firstName
	 * @return
	 * 
	 */

	public String getFirstNameWithfirstUppercase(String firstName) {
		firstName = firstName.toLowerCase();

		firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1, firstName.length());
		return firstName;
	}

	/**
	 * /* Constructor Return name with toUppercase *
	 * 
	 * @param firstName
	 * @param User
	 * @return
	 * 
	 */

	public String getUser(String lastName) {

		this.lastName = lastName.toUpperCase();
		return lastName;
	}

	@Override
	public String toString() {
		return "User [userId=" + id + ", firstName=" + firstName + ", " + "lastName=" + lastName + "," + "email="
				+ firstEmail + "," + "address" + address + "," + "postalcode" + postalcode + "," + "city" + city + ","
				+ "telephone" + telephone + "," + "password" + password + "," + "username" + username + "]";

	}

}
