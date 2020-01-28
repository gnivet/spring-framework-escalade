package org.springframework.samples.escalade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/**
 * Simple business object representing a comment.
 *
 * @author Guillaume Nivet
 */

@Entity
@Table(name = "comments")
public class Comment extends NamedEntity {

	
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = true)
	private User user;	
	
	@ManyToOne
	@JoinColumn(name = "site_id", nullable = true)
	private Site site;	
	
	@Column(name = "comment")
	@NotEmpty
	private String comment;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @param user
	 * @param site
	 * @param comment
	 */
	public Comment(User user, Site site, @NotEmpty String comment) {
		this.user = user;
		this.site = site;
		this.comment = comment;
	}

	public Comment() {
		// TODO Auto-generated constructor stub
	}

	
	
	}
