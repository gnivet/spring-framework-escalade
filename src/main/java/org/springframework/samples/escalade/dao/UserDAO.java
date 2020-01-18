package org.springframework.samples.escalade.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.escalade.beanform.UserForm;
import org.springframework.samples.escalade.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDAO {

	@Autowired
	private PasswordEncoder passwordEncoder;

	private static final Map<Long, User> USERS_MAP = new HashMap<>();

	public static void put(Long userId, User tom) {
		// TODO Auto-generated method stub

	}

	static {
		initDATA();
	}

	private static void initDATA() {
		String encrytedPassword = "";

		User tom = new User();
		User jerry = new User();

		USERS_MAP.put(tom.getUserId(), tom);
		USERS_MAP.put(jerry.getUserId(), jerry);

	}

		
	public Long getMaxUserId() {
		long max = 0;
		for (Long id : USERS_MAP.keySet()) {
			if (id > max) {
				max = id;
			}
		}
		return max;
	}
	
	public User findUserByUserName(String userName) {
		Collection<User> Users = USERS_MAP.values();
		for (User u : Users) {
			if (u.getUserName().equals(userName)) {
				return u;
			}
		}
		return null;
	}

	@Autowired
	private EntityManager entityManager;

	public User findUserAccount(String userName) {
		try {
			String sql = "Select e from " + User.class.getName() + " e " //
					+ " Where e.userName = :userName ";

			Query query = entityManager.createQuery(sql, User.class);
			query.setParameter("userName", userName);

			return (User) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public User createUser(UserForm form) {
        Long userId = this.getMaxUserId() + 1;
        String encrytedPassword = this.passwordEncoder.encode(form.getPassword());
 
        User user = new User();
        USERS_MAP.put(userId, user);
        return user;
    }

	

	

}