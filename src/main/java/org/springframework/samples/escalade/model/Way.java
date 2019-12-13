package org.springframework.samples.escalade.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity  
@Table(name="ways")  
public class Way extends NamedEntity{
	@ManyToOne
    @JoinColumn(name = "way_id")
    private WayType type;
	
	 /**
	 * Holds value of property roles. FOREIGN KEY (partie_id)
	 */
				
	@ManyToOne
	@JoinColumn(name = "part_id", nullable = true)
	private Part part;
}