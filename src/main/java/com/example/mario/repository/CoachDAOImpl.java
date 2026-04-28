package com.example.mario.repository;

import com.example.mario.exception.EntityNotFound;
import com.example.mario.model.Coach;
import com.example.mario.model.VolleyballCoach;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class  CoachDAOImpl{

    private final EntityManager entityManager;

    public CoachDAOImpl(
            EntityManager entityManager
    ) {
        this.entityManager = entityManager;
    }

    public void save(VolleyballCoach coach) {
        entityManager.persist(coach);
    }

    public List<Coach> findAllByLastName(String lastName) {

        TypedQuery<Coach> query = entityManager.createQuery("SELECT c FROM VolleyballCoach AS c WHERE c.lastName LIKE :lastNameParam", Coach.class);
        query.setParameter("lastNameParam", lastName);

        return query.getResultList();
    }

    public Coach update(Coach coach) {
        return entityManager.merge(coach);
    }

    public List<Coach> findAll() {

        TypedQuery<Coach> query = entityManager.createQuery("SELECT c FROM VolleyballCoach AS c", Coach.class);

        return query.getResultList();
    }

    @Transactional
    public Coach testMethod(Coach coach) {
        return entityManager.merge(coach);
    }

    public Coach findByEmail(String email) {
        TypedQuery<Coach> typedQuery = entityManager.createQuery("SELECT vc FROM VolleyballCoach AS vc WHERE vc.email LIKE :emailParam", Coach.class);
        typedQuery.setParameter("emailParam", email);

        try {
            return typedQuery.getSingleResult();
        } catch (NoResultException exception) {
            throw new EntityNotFound("User with such email doesn't exists");
        }
    }
}
