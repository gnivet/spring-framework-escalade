package org.springframework.samples.escalade.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity  
@Table(name="zones")  
public class Zone extends NamedEntity{
	@ManyToOne
    @JoinColumn(name = "zone_id")
    private ZoneType type;
	
	 /**
	 * Holds value of property roles. FOREIGN KEY (way_id)
	 */
					
	@ManyToOne
	@JoinColumn(name = "way_id", nullable = true)
	private Way way;
}
