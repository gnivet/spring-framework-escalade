package org.springframework.samples.escalade.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Comment;
import org.springframework.samples.escalade.model.NamedEntity;

public interface CommentRepository {

	Comment findCommentById(Integer id) throws DataAccessException;

	Comment saveComment(Comment comment) throws DataAccessException;

	Collection<Comment> findCommentByName(String name) throws DataAccessException;

	Integer findCommentNumber(String userName)throws DataAccessException;

	Integer findByUsername(String userName)throws DataAccessException;


	Collection<Comment> findCommentByUsername(String userName)throws DataAccessException;

	NamedEntity updateComment(Comment comment)throws DataAccessException;

	Integer findCountNumberCommentByUsername(String userName) throws DataAccessException;
	
	
}
