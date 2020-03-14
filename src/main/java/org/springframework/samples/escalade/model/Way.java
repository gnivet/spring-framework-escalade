package org.springframework.samples.escalade.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ways")
public class Way extends NamedEntity {

	/**
	 * Holds value of property roles. FOREIGN KEY (partie_id)
	 */
		
	@ManyToOne
	@JoinColumn(name = "zone_id", nullable = true)
	private Zone zone;

	@OneToMany(mappedBy = "way")
	private Set<Length> lengths;

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public Set<Length> getLengths() {
		return lengths;
	}

	public void setLengths(Set<Length> lengths) {
		this.lengths = lengths;
	}

	/**
	 * 
	 */
	public Way() {
	}

	@Override
	public String toString() {
		return "Way [zone=" + zone + ", lengths=" + lengths + "]";
	}
	
	
	

}