package com.example.mario.dao;

import com.example.mario.model.Coach;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CoachDAOImpl implements CoachDAO{

    private final EntityManager entityManager;

    public CoachDAOImpl(
            EntityManager entityManager
    ) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Coach coach) {
        entityManager.persist(coach);
    }
}
