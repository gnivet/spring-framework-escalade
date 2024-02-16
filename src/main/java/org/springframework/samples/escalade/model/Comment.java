package org.springframework.samples.escalade.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Simple business object representing a comment.
 *
 * @author Guillaume Nivet
 */

@Entity
@Table(name = "comments")
public class Comment extends NamedEntity {



	@ManyToOne
	@JoinColumn(name = "site_id", nullable = true)
	private Site site;
	
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = true)
	private User user;
	

	@Column(name = "comment")
	@NotEmpty
	private String comment;

	/**
     * Holds value of property date.
     */
    @Column(name = "visit_date")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate date;

	public Site getSite() {
		return this.site;
	}

	public void setSite(Site site) {
		this.site = site;
	}
	

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	



	public Comment() {
		// TODO Auto-generated constructor stub
		this.date = LocalDate.now();
	}





	}
