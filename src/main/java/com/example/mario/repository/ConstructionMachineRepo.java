package com.example.mario.repository;

import com.example.mario.exception.EntityNotFound;
import com.example.mario.model.Machine;
import com.example.mario.model.ConstructionEquipment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ConstructionMachineRepo {

    private final EntityManager entityManager;

    public ConstructionMachineRepo(
            EntityManager entityManager
    ) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void save(ConstructionEquipment machine) {
        entityManager.persist(machine);
    }

    public List<Machine> findAll() {

        TypedQuery<Machine> query = entityManager.createQuery("SELECT ce FROM ConstructionEquipment AS ce", Machine.class);

        return query.getResultList();
    }

    public Machine findByVIN(String vin) {
        TypedQuery<Machine> typedQuery = entityManager.createQuery("SELECT ce FROM ConstructionEquipment AS ce WHERE ce.vin LIKE :vinParam", Machine.class);
        typedQuery.setParameter("vinParam", vin);

        try {
            return typedQuery.getSingleResult();
        } catch (NoResultException exception) {
            throw new EntityNotFound("Machine with such VIN doesn't exists");
        }
    }
}
