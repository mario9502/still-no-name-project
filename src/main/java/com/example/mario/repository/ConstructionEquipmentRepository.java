package com.example.mario.repository;

import com.example.mario.model.ConstructionEquipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstructionEquipmentRepository extends JpaRepository<ConstructionEquipment, Integer> {

    ConstructionEquipment findByVin(String vin);

    void deleteByVin(String vin);
}
