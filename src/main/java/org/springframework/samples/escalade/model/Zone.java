package org.springframework.samples.escalade.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity  
@Table(name="zones")  
public class Zone extends NamedEntity{
	//foreign key
	@ManyToOne
	@JoinColumn(name = "site_id", nullable = true)
	private Site site;	
	public Zone(Site site, User user, Set<Way> ways) {
		super();
		this.site = site;
		this.user = user;
		this.ways = ways;
	}

	//foreign key			
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = true)
	private User user;	

	@OneToMany(targetEntity = Way.class, cascade = CascadeType.ALL, mappedBy = "zone" , fetch=FetchType.EAGER)
    private Set<Way> ways;		
	
	
	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public Set<Way> getWays() {
		return ways;
	}

	public void setWays(Set<Way> ways) {
		this.ways = ways;
	}
		
	
	/**
	 * 
	 */
	public Zone() {
	}
		
		
	
}


