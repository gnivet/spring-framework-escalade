package org.springframework.samples.escalade.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="zones")
public class Zone extends NamedEntity{
	
	
	//foreign key
	@ManyToOne
	@JoinColumn(name = "site_id", nullable = true)
	private Site site;
	
	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}
	
	//foreign key
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = true)
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

}


