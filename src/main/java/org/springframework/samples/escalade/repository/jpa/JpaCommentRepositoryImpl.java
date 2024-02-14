package org.springframework.samples.escalade.repository.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Comment;
import org.springframework.samples.escalade.model.NamedEntity;
import org.springframework.samples.escalade.repository.CommentRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class JpaCommentRepositoryImpl implements CommentRepository {

	@PersistenceContext
	private EntityManager em;

	public Comment findCommentById(Integer id) {

		Query query = this.em.createQuery("SELECT comment FROM Comment comment WHERE comment.id =:id");
		query.setParameter("id", id);
		return (Comment) query.getSingleResult();
	}

	public Comment saveComment(Comment comment) {

		if (comment.getId() == null) {
			this.em.persist(comment);
		} else {
			this.em.merge(comment);
		}
		return comment;

	}

	
	@SuppressWarnings("unchecked")
	public Collection<Comment> findCommentByName(String name) {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery("SELECT comment from Comment comment"
		+ " join comment.site site on site.id = comment.id"
		+ " WHERE comment.name LIKE :name");
		query.setParameter("name", "%" + name + "%");
		return query.getResultList();
	}

	@Override
	public Integer findCommentNumber(String userName) throws DataAccessException {
		// TODO Auto-generated method stub
		/*
		 * Query query = this.em.createQuery("select count(*) from Site site " +
		 * "left join User user on site.user.id = user.id " +
		 * "left join Comment comment on site.id = comment.site.id" +
		 * " where user.username like :userName"); query.setParameter("userName",
		 * userName);
		 */
		Query query = this.em.createQuery("select count(*) from Comment comment"
				+ " join User user on comment.user.id = user.id" + " where user.userName like :userName");
		query.setParameter("userName", userName);
		return (Integer) query.getSingleResult();

	}

	@Override
	public Integer findByUsername(String userName) throws DataAccessException {
		// TODO Auto-generated method stub
		Query query = this.em.createQuery(
				"select count(*) from Comment comment join User user on comment.user.id = user.id where user.userName like :userName");
		query.setParameter("userName", userName);
		try {
			return (Integer) query.getSingleResult();
			
		}
		catch(Exception e) {
			  //  Block of code to handle errors
			System.out.println("Something went wrong.");
			}	
		return null;
		
	}

	@SuppressWarnings("unchecked")
	public Collection<Comment> findCommentByUsername(String userName) throws DataAccessException {

		Query query = this.em.createQuery(
				"select comment from Comment comment join User user on comment.user.id = user.id where user.userName like :userName");
		query.setParameter("userName", userName);
		return query.getResultList();

	}

	@Override
	public NamedEntity updateComment(Comment comment) throws DataAccessException {
		// TODO Auto-generated method stub
		if (!this.em.contains(comment))
			this.em.merge(comment);
		return comment;
	}

}