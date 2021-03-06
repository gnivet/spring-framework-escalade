package org.springframework.samples.escalade.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity  
@Table(name="zones")  
public class Zone extends NamedEntity{
	
								
	@ManyToOne(targetEntity = Site.class, fetch=FetchType.EAGER)
	@JoinColumn(name = "site_id")
	private Site site;

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
	
	
	

	/**
	 * Constructor with parameters
	 * @param site
	 * @param ways
	 */
	public Zone(Site site, Set<Way> ways) {
		this.site = site;
		this.ways = ways;
	}

	@Override
	public String toString() {
		return "Zone [site=" + site + ", ways=" + ways + "]";
	}

		
	
}


