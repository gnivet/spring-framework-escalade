package org.springframework.samples.escalade.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity  
@Table(name="reservationBouquins")  
public class ReservationBouquin extends NamedEntity{

	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = true)
	private User user;	
	
	private Boolean accepted;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getAccepted() {
		return accepted;
	}

	public void setAccepted(Boolean accepted) {
		this.accepted = accepted;
	}	
	
}