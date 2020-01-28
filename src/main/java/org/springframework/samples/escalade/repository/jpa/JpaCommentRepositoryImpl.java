package org.springframework.samples.escalade.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.samples.escalade.model.Comment;

public class JpaCommentRepositoryImpl {

	@PersistenceContext
	private EntityManager em;

	public Comment findCommentById(long id) {
		return this.em.find(Comment.class, id);
	}

	
}
