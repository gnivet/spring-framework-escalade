package org.springframework.samples.escalade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Guillaume Nivet
 *         Can be ...
 */
@Entity
@Table(name = "commentaires")
public class Commentaire {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "base_entity_generator")
	@SequenceGenerator(name = "base_entity_generator", sequenceName = "base_entity_sequence")
	protected Long id;
	
	
	@Column(name = "commentaire")	
	protected String commentaire;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = true)
	private User user;	
	
	@ManyToOne
	@JoinColumn(name = "site_id", nullable = true)
	private Site site;	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isNew() {
		return this.id == null;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Site getSite() {
		return site;
	}

	
	
}
