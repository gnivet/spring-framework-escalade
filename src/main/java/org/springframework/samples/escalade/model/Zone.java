package org.springframework.samples.escalade.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity  
@Table(name="zones")  
public class Zone extends NamedEntity{
	
								
	@ManyToOne
	@JoinColumn(name = "site_id", nullable = false)
	private Site site;

	@OneToMany(mappedBy="zone")
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
	
	
}


