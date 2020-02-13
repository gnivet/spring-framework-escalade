package org.springframework.samples.escalade.repository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Comment;

public interface CommentRepository {
	@Autowired
	Comment findCommentById(Integer id) throws DataAccessException;
	@Autowired
	void saveComment(Comment comment) throws DataAccessException;
	@Autowired
	Collection<Comment> findCommentByName(String name) throws DataAccessException;
}
