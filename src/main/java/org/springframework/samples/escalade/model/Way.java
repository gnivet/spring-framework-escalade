package org.springframework.samples.escalade.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ways")
public class Way extends NamedEntity {

	/**
	 * Holds value of property roles. FOREIGN KEY (partie_id)
	 */
	
	@ManyToOne
	@JoinColumn(name = "site_id", nullable = true)
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
}