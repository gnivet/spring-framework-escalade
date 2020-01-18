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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;

/**
 * Simple JavaBean domain object representing a user.
 * 
 * @author Guillaume Nivet
 */


@Entity
@Table(name = "users", //
		uniqueConstraints = { //
				@UniqueConstraint(name = "USER_UK", columnNames = "User_Name") })
public class User {

	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "base_entity_generator")
	@SequenceGenerator(name = "base_entity_generator", sequenceName = "base_entity_sequence")
	@Column(name = "User_Id", nullable = false)
	private Long userId;
	
	
	@Column(name = "User_Name", length = 36, nullable = false)
	private String userName;

	//@Column(name = "Encryted_Password", length = 128, nullable = false)
	@Column(name = "Encryted_Password", length = 128, nullable = false)
	private String encrytedPassword;

	@Column(name = "Enabled", length = 1, nullable = false)
	private boolean enabled;

	@Column(name = "address")
	
	private String address;

	@Column(name = "postalcode")
	
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
	
	private String city;

	@Column(name = "telephone")	
	@Digits(fraction = 0, integer = 10)
	private String telephone;

	
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

	@Column(name = "password")
	protected String password;

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
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

	@Column(name = "lastName")
	private String lastName;

	

	@OneToMany(mappedBy="user")
    private Set<Topo> topos;

	@OneToMany(mappedBy="user")
    private Set<Reservation> reservations;

			
	

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


	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	public Set<Topo> getTopos() {
		return topos;
	}

	public void setTopos(Set<Topo> topos) {
		this.topos = topos;
	}

	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	

	

		
	
	
	


	public User findUserAccount(String userName2) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addTopo(Site topo) {
		// TODO Auto-generated method stub
		
	}

	public Object getTopo(String name, boolean b) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public User() {
		// TODO Auto-generated constructor stub
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
	 * @param password
	 * @param lastName
	 * @param topos
	 * @param reservations
	 */
	public User(Long userId, String userName, String encrytedPassword, boolean enabled,  String address,
		String postalcode, Set<Area> areas, String city,
		String telephone, String password, String lastName,
		Set<Topo> topos, Set<Reservation> reservations)
		{
		this.userId = userId;
		this.userName = userName;
		this.encrytedPassword = encrytedPassword;
		this.enabled = enabled;
		this.address = address;
		this.postalcode = postalcode;
		this.areas = areas;
		this.city = city;
		this.telephone = telephone;
		this.password = password;
		this.lastName = lastName;
		this.topos = topos;
		this.reservations = reservations;
		}

	public User(long userId, String userName, String encrytedPassword, String enabled, String address,
			String postalcode, String city, String telephone, String password, String lastName, String topo,
			String reservation) {
		// TODO Auto-generated constructor stub
	}


	
		
	

	
	
	
}
