package org.springframework.samples.escalade.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lengths")
public class Length extends NamedEntity {

	@Column(name = "cotation")
	//@NotNull
	private Integer cotation;

	@Column(name = "under_cotation")
	//@NotEmpty
	private String under_cotation;

	@Column(name = "comment")
	//@NotEmpty
	private String comment;


	@Column(name = "length_status")
	//@NotNull
	private boolean length_status;


	public Integer getCotation() {
		return cotation;
	}

	public void setCotation(Integer cotation) {
		this.cotation = cotation;
	}

	public String getUnder_cotation() {
		return under_cotation;
	}

	public void setUnder_cotation(String under_cotation) {
		this.under_cotation = under_cotation;
	}


	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isLength_status() {
		return length_status;
	}

	public void setLength_status(boolean length_status) {
		this.length_status = length_status;
	}

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = true)
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	/**
	 *
	 */
	public Length() {
	}


}
