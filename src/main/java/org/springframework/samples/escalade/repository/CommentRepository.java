package org.springframework.samples.escalade.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Comment;

public interface CommentRepository {
	
	Comment findCommentById(Integer id) throws DataAccessException;
	
	void saveComment(Comment comment) throws DataAccessException;
	
	Collection<Comment> findCommentByName(String name) throws DataAccessException;
}
