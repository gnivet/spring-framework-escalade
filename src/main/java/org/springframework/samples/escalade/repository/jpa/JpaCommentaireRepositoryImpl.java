package org.springframework.samples.escalade.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Commentaire;
import org.springframework.samples.escalade.repository.CommentaireRepository;

public class JpaCommentaireRepositoryImpl implements CommentaireRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Commentaire findById(long id) {
		
		Query query = this.em.createQuery("SELECT commentaire FROM Commentaire commentaire WHERE commentaire.id =:id");
		query.setParameter("id", id);
		return (Commentaire) query.getSingleResult();
	}
	
	
	@Override
	public void saveCommentaire(Commentaire commentaire) throws DataAccessException {
		// TODO Auto-generated method stub
		if (commentaire.getId() == null) {
			this.em.persist(commentaire);
		} else {
			this.em.merge(commentaire);
		}
	}

}
