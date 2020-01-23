package org.springframework.samples.escalade.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author Guillaume Nivet Can be ...
 * @param
 */
@Entity
@Table(name = "commentaires")
public class Commentaire extends NamedEntity {

	protected String commentaire;
	
	  @ManyToOne	  
	  @JoinColumn(name = "user_id", nullable = true)
	  private UserType userType;
	  
	  @ManyToOne
	  
	  @JoinColumn(name = "site_id", nullable = true)
	  private SiteType siteType;
	  
	 
	  
	 
	  /*
	  @OneToMany(cascade = CascadeType.ALL, mappedBy = "commentaire") private
	  Set<User> users;
	  
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "commentaire") private
	  Set<Site>sites;
	 */
	@Transient  
	@OneToMany(mappedBy = "commentaire")
	private Set<User> users;

	@Transient  
	@OneToMany(mappedBy = "commentaire")
	private Set<Site> sites;

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Site> getSites() {
		return sites;
	}

	public void setSites(Set<Site> sites) {
		this.sites = sites;
	}

	
	public Commentaire() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Commentaire [commentaire=" + commentaire + ", userType=" + userType + ", siteType=" + siteType
				+ ", users=" + users + ", sites=" + sites + ", id=" + id + "]";
	}

	/**
	 * @param commentaire
	 * @param userType
	 * @param siteType
	 * @param users
	 * @param sites
	 */
	public Commentaire(String commentaire, UserType userType, SiteType siteType, Set<User> users, Set<Site> sites) {
		this.commentaire = commentaire;
		this.userType = userType;
		this.siteType = siteType;
		this.users = users;
		this.sites = sites;
	}
	
	
	
	
}
