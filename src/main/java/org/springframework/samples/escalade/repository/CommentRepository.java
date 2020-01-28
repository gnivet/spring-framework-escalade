package org.springframework.samples.escalade.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Comment;

public interface CommentRepository {

	Comment findById(Long id) throws DataAccessException;
	void saveComment(Comment comment)throws DataAccessException;
}
