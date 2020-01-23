package org.springframework.samples.escalade.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Commentaire;



public interface CommentaireRepository {
	
	Commentaire findById(long id)  throws DataAccessException;	
	
	void saveCommentaire(Commentaire commentaire) throws DataAccessException;

	
}
