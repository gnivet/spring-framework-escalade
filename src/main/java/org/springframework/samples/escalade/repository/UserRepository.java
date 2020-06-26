package org.springframework.samples.escalade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.escalade.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	/**
     * Retrieve a <code>User</code> from the data store by id.
     *
     * @param userName the userName to search for
	 * @param userId 
     * @return the <code>userId</code> if found
     * @throws org.springframework.dao.DataRetrievalFailureException if not found
     */
	
    User findByUsername(String username);

	User findById(int userId);

	//User findUserIdByUserName(String username);
	
	
}


