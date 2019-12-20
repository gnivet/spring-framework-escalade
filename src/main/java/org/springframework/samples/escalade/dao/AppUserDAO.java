package org.springframework.samples.escalade.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.escalade.beanform.AppUserForm;
import org.springframework.samples.escalade.model.AppUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AppUserDAO {

	@Autowired
	private PasswordEncoder passwordEncoder;

	private static final Map<Long, AppUser> USERS_MAP = new HashMap<>();

	public static void put(Long userId, AppUser tom) {
		// TODO Auto-generated method stub

	}

	static {
		initDATA();
	}

	private static void initDATA() {
		String encrytedPassword = "";

		AppUser tom = new AppUser(1L, "tom", encrytedPassword, false);
		AppUser jerry = new AppUser(2L, "jerry", encrytedPassword, false);

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
	
	public AppUser findAppUserByUserName(String userName) {
		Collection<AppUser> appUsers = USERS_MAP.values();
		for (AppUser u : appUsers) {
			if (u.getUserName().equals(userName)) {
				return u;
			}
		}
		return null;
	}

	@Autowired
	private EntityManager entityManager;

	public AppUser findUserAccount(String userName) {
		try {
			String sql = "Select e from " + AppUser.class.getName() + " e " //
					+ " Where e.userName = :userName ";

			Query query = entityManager.createQuery(sql, AppUser.class);
			query.setParameter("userName", userName);

			return (AppUser) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public AppUser createAppUser(AppUserForm form) {
        Long userId = this.getMaxUserId() + 1;
        String encrytedPassword = this.passwordEncoder.encode(form.getPassword());
 
        AppUser user = new AppUser(userId, form.getUserName(), encrytedPassword, false);
        USERS_MAP.put(userId, user);
        return user;
    }

	

	

}