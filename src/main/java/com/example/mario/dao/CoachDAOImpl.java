package com.example.mario.dao;

import com.example.mario.model.Coach;
import com.example.mario.model.VolleyballCoach;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class  CoachDAOImpl implements CoachDAO{

    private final EntityManager entityManager;

    public CoachDAOImpl(
            EntityManager entityManager
    ) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(VolleyballCoach coach) {
        entityManager.persist(coach);
    }

    @Override
    public List<Coach> findAllByLastName(String lastName) {

        TypedQuery<Coach> query = entityManager.createQuery("SELECT c FROM VolleyballCoach AS c WHERE c.lastName LIKE :lastNameParam", Coach.class);
        query.setParameter("lastNameParam", lastName);

        return query.getResultList();
    }

    @Override
    @Transactional
    public Coach update(Coach coach) {
        return entityManager.merge(coach);
    }

    @Override
    public List<Coach> findAll() {

        TypedQuery<Coach> query = entityManager.createQuery("SELECT c FROM VolleyballCoach AS c", Coach.class);

        return query.getResultList();
    }

    @Transactional
    public Coach testMethod(Coach coach) {
        return entityManager.merge(coach);
    }
}
