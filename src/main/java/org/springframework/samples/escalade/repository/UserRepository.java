package org.springframework.samples.escalade.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.escalade.model.TopoBkg;
import org.springframework.samples.escalade.model.Comment;
import org.springframework.samples.escalade.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserName(String userName);

	@Override
	Optional<User> findById(Integer userId);

	long countByEmail(String email);

	List<User> findByLastNameAndEmail(String lastName, String email);

	List<User> findByLastNameOrEmail(String lastName, String email);

	List<User> findByLastNameAndFirstName(String lastName, String firstName);


	@Query("SELECT t FROM TopoBkg t WHERE t.user.userName LIKE :userName")
	List<TopoBkg> getAllTopoBkgsUserName(@Param("userName") String userName);


	@Query("SELECT t FROM TopoBkg t WHERE t.id =:topoBkgId")
	User findSingleTopoBkgById(@Param("topoBkgId") Integer topoBkgId);

	Optional<User> findUserById(Integer id);
		
	@Query("SELECT t FROM Comment t WHERE t.user.userName LIKE :userName")
	List<Comment> getAllCommentsUserName(@Param("userName") String userName);
}
