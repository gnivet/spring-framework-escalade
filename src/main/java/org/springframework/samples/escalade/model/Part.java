package org.springframework.samples.escalade.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity  
@Table(name="parts")  
public class Part extends NamedEntity{
	@ManyToOne
    @JoinColumn(name = "partie_id")
    private PartieType type;
	
	 /**
	 * Holds value of property roles. FOREIGN KEY (length_id)
     */
			
	 @ManyToOne
	 @JoinColumn(name = "length_id", nullable = true)
	 private Length length;
}
