package org.springframework.samples.escalade.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Guillaume Nivet
 *         Can be ...
 */
@Entity
@Table(name = "points")
public class Point extends NamedEntity {

	//@ManyToOne
	//@JoinColumn(name = "length_id", nullable = true)
	//private Length length;

	public Length getLength() {
		return length;
	}

	public void setLength(Length length) {
		this.length = length;
	}
	
	@ManyToOne(targetEntity = Length.class,  cascade=CascadeType.ALL)
	@JoinColumn(name = "length_id")
	private Length length;

	/**
	 * 
	 */
	public Point() {
	}
		
	
}


