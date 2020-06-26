package org.springframework.samples.escalade.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "topoBkgs")
public class TopoBkg  extends NamedEntity  {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = true)
	private User user;

	@Column(name = "accepted" , nullable = true)	
	private Boolean accepted;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "topo_id", nullable = true)
	private Topo topo;

	@Column(name = "borrowDate")
	@DateTimeFormat(pattern = "yyyy/MM/dd")	
	@Past
	private Date borrowDate;

	@Column(name = "borrowEndDate")
	@DateTimeFormat(pattern = "yyyy/MM/dd")	
	@Future
	private Date borrowEndDate;

	@Column(name = "inProgress" , nullable = true)
	private boolean inProgress;

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

	public Topo getTopo() {
		return topo;
	}

	public void setTopo(Topo topo) {
		this.topo = topo;
	}

	
	
	public Date getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public Date getBorrowEndDate() {
		return borrowEndDate;
	}

	public void setBorrowEndDate(Date borrowEndDate) {
		this.borrowEndDate = borrowEndDate;
	}

	public boolean isInProgress() {
		return inProgress;
	}

	public void setInProgress(boolean inProgress) {
		this.inProgress = inProgress;
	}

	/**
	 * 
	 */
	public TopoBkg() {
	}

	



	

}