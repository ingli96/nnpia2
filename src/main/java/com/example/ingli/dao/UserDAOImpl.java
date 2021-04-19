package com.example.ingli.dao;

import com.example.ingli.Controller.model.User;
import com.example.ingli.Controller.model.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Repository
public class UserDAOImpl {

    @Autowired
    private EntityManager em;

    public User getUserWithDetails(Long id) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);

        root.fetch("userDetail", JoinType.LEFT);
        Predicate userPredicate = cb.equal(root.get("id"), id);
        cq.where(userPredicate);
        TypedQuery<User> query = em.createQuery(cq);
        return query.getSingleResult();
    }


}
