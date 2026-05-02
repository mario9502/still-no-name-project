package com.example.mario.repository;

import com.example.mario.exception.EntityNotFound;
import com.example.mario.model.ConstructionEquipment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ConstructionMachineDAO {

    private static final Logger log = LoggerFactory.getLogger(ConstructionMachineDAO.class);
    private final EntityManager entityManager;

    public ConstructionMachineDAO(
            EntityManager entityManager
    ) {
        this.entityManager = entityManager;
    }

    @Transactional
    public ConstructionEquipment save(ConstructionEquipment machine) {
        entityManager.persist(machine);
        return machine;
    }

    public List<ConstructionEquipment> findAll() {

        TypedQuery<ConstructionEquipment> query = entityManager.createQuery("SELECT ce FROM ConstructionEquipment AS ce", ConstructionEquipment.class);

        return query.getResultList();
    }

    public ConstructionEquipment findByVIN(String vin) {
        TypedQuery<ConstructionEquipment> typedQuery = entityManager.createQuery("SELECT ce FROM ConstructionEquipment AS ce WHERE ce.vin LIKE :vinParam", ConstructionEquipment.class);
        typedQuery.setParameter("vinParam", vin);

        try {
            return typedQuery.getSingleResult();
        } catch (NoResultException exception) {
            throw new EntityNotFound("Machine with such VIN doesn't exists");
        }
    }

    @Transactional
    public void deleteByVin(String vin) {
        try {
            ConstructionEquipment constructionEquipment = findByVIN(vin);
            entityManager.remove(constructionEquipment);
        } catch (EntityNotFound ignored) {
            log.info("No such entity existed in the DB.");
        }
    }
}
