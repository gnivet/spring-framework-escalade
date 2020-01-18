package org.springframework.samples.escalade.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Commentaire;

public interface CommentaireRepository {
	
	Commentaire findById(long id);	
	
	void saveCommentaire(Commentaire commentaire) throws DataAccessException;

	static Collection<Commentaire> findSiteByName(String commentaire) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
