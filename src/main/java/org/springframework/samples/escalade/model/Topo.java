package org.springframework.samples.escalade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "topos")
public class Topo extends NamedEntity {

	@Column(name = "comment")
	@NotEmpty
	private String comment;
	
	@Column(name = "date")
	private Boolean date;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = true)
	private User user;

	public void setUser(User user) {
		// TODO Auto-generated method stub
		
	}	
		
}