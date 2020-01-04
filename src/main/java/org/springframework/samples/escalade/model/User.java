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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
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
	@Table(name = "users", //
	        uniqueConstraints = { //
	                @UniqueConstraint(name = "USER_UK", columnNames = "User_Name") })
	public class User   {
	 
	    @Id
	    @GeneratedValue
	    @Column(name = "User_Id", nullable = false)
	    private Long userId;
	 
	    @Column(name = "User_Name", length = 36, nullable = false)
	    private String userName;
	 
	    @Column(name = "Encryted_Password", length = 128, nullable = false)
	    private String encrytedPassword;
	 
	    @Column(name = "Enabled", length = 1, nullable = false)
	    private boolean enabled;
	    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
	
	@Column(name = "lastName")
	private String lastName;

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
	/*
	@Override
	public String toString() {
		return "User [address=" + address + ", postalcode=" + postalcode + ", areas=" + areas + ", city=" + city
				+ ", telephone=" + telephone + ", topos=" + topos + ", username=" + username + ", password=" + password
				+ ", role=" + role + ", valid=" + valid + "]";
	}
	*/

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEncrytedPassword() {
		return encrytedPassword;
	}

	public void setEncrytedPassword(String encrytedPassword) {
		this.encrytedPassword = encrytedPassword;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Area> getAreas() {
		return areas;
	}

	public void setAreas(Set<Area> areas) {
		this.areas = areas;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setTopos(Set<Topo> topos) {
		this.topos = topos;
	}

	/**
	 * @param userId
	 * @param userName
	 * @param encrytedPassword
	 * @param enabled
	 * @param address
	 * @param postalcode
	 * @param areas
	 * @param city
	 * @param telephone
	 * @param topos
	 * @param username2
	 * @param password
	 * @param role
	 * @param valid
	 * @param lastName
	 */
	public User(Long userId, String userName, String encrytedPassword, boolean enabled, @NotEmpty String address,
			@NotEmpty String postalcode, Set<Area> areas, @NotEmpty String city,
			@NotEmpty @Digits(fraction = 0, integer = 10) String telephone, Set<Topo> topos, String username2,
			String password, Role role, boolean valid, String lastName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.encrytedPassword = encrytedPassword;
		this.enabled = enabled;
		this.address = address;
		this.postalcode = postalcode;
		this.areas = areas;
		this.city = city;
		this.telephone = telephone;
		this.topos = topos;
		username = username2;
		this.password = password;
		this.role = role;
		this.valid = valid;
		this.lastName = lastName;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	
	

}
