package org.springframework.samples.escalade.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "topos")
public class Topo extends NamedEntity {

	@Column(name = "comment")
	@NotEmpty
	private String comment;
	
	@Column(name = "comment_date")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate commentDate;
	
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
	

	public LocalDate getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(LocalDate commentDate) {
		this.commentDate = commentDate;
	}

	public User getUser() {
		return user;
	}	
		
	
}