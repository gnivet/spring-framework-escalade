package org.springframework.samples.escalade.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "topos")
public class Topo extends NamedEntity {

	@Column(name = "description")
	@NotEmpty(message ="Please add a description")
	//@Size(min = 2)
	private String description;

	@Column(name = "available")	
	@AssertTrue
	private boolean available;

	@Column(name = "comment_date")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Past
	private LocalDate commentDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = true)
	private User user;

	
	public TopoBkg getTopo_booking() {
		return topoBkg;
	}

	public void setTopo_booking(TopoBkg topoBkg) {
		this.topoBkg = topoBkg;
	}

	@OneToOne(targetEntity = TopoBkg.class, mappedBy = "topo")
	private TopoBkg topoBkg;
	
	public void setUser(User user) {
		// TODO Auto-generated method stub

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public LocalDate getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(LocalDate commentDate) {
		this.commentDate = commentDate;
	}

	

	public User getUser() {
		return user;
	}

	/**
	 * 
	 */

	public Topo() {
	}

}