package org.springframework.samples.escalade.repository.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.samples.escalade.model.Comment;
import org.springframework.samples.escalade.repository.CommentRepository;
import org.springframework.stereotype.Repository;

@Repository
public class JpaCommentRepositoryImpl implements CommentRepository{

	@PersistenceContext
	private EntityManager em;

	public Comment findCommentById(Integer id) {
		
		Query query = this.em.createQuery("SELECT comment FROM Comment comment WHERE comment.id =:id");
		query.setParameter("id", id);
		return (Comment) query.getSingleResult();
	}

	public void saveComment(Comment comment) {

		if (comment.getId() == null) {
			this.em.persist(comment);
		} else {
			this.em.merge(comment);
		}

	}
	
	@SuppressWarnings("unchecked")
	public Collection<Comment> findCommentByName(String name) {
		// TODO Auto-generated method stub
    	 
		
    	Query query = this.em.createQuery("SELECT DISTINCT comment from Comment comment WHERE comment.name LIKE :name");
		 query.setParameter("name", name + "%");
		 return query.getResultList();
	}
    
}
