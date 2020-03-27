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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/**
 * Simple business object representing a Area.
 *
 * @author Guillaume Nivet
 */

@Entity
@Table(name = "areas")
public class Area extends NamedEntity {

	@Column(name = "street")
	private String street;

	@Column(name = "postalcode")
	@NotEmpty String postalcode;	
	
	
	public String setPostalcode(String postalcode) {
		return this.postalcode = postalcode;
	}
	
	public String getPostalcode() {
		return postalcode;
	}

	@Column(name = "city")
	@NotEmpty
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

	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	/*
	 * You should include cascade="all" (if using xml) or cascade=CascadeType.ALL (if using annotations) on your collection mapping.

		This happens because you have a collection in your entity, and that collection has one or more items which are not present
		 in the database. By specifying the above options you tell hibernate to save them to the database when saving their parent.
	 */
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "site_id", nullable = true )
	private Site site;

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = true)
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 
	 */
	public Area() {
	}

	/**
	 * @param street
	 * @param postalcode
	 * @param city
	 * @param country
	 * @param gpscoordinate
	 */
	public Area(String street, String postalcode, String city, String country, String gpscoordinate) {
		this.street = street;
		this.postalcode = postalcode;
		this.city = city;
		this.country = country;
		this.gpscoordinate = gpscoordinate;
	}

	
}