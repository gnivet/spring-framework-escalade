package org.springframework.samples.escalade.dao;
 
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.escalade.model.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 
@Repository
@Transactional
public class RoleDAO {
 
    @Autowired
    private EntityManager entityManager;
 
    public List<String> getRoleNames(Long userId) {
        String sql = "Select ur.Role.roleName from " + Role.class.getName() + " ur " //
                + " where ur.User.userId = :userId ";
 
        Query query = this.entityManager.createQuery(sql, String.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }
 
}
