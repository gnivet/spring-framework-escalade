package org.springframework.samples.escalade.model;

import java.sql.Date;

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
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = true)
	private User user;

	public void setUser(User user) {
		// TODO Auto-generated method stub
		
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}	
		
	
}