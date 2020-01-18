package org.springframework.samples.escalade.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservations")
public class Reservation extends NamedEntity {
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = true)
	private User user;

	
	
}
