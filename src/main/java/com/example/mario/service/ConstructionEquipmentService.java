package com.example.mario.service;

import com.example.mario.repository.ConstructionEquipmentRepository;
import com.example.mario.model.ConstructionEquipment;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ConstructionEquipmentService {

    private final ConstructionEquipmentRepository constructionEquipmentRepository;
    private final ObjectMapper objectMapper;

    public ConstructionEquipmentService(
            ConstructionEquipmentRepository constructionEquipmentRepository,
            ObjectMapper objectMapper
            ) {
        this.constructionEquipmentRepository = constructionEquipmentRepository;
        this.objectMapper = objectMapper;
    }

    public ConstructionEquipment addConstructionMachine(ConstructionEquipment machine) {
        return constructionEquipmentRepository.save(machine);
    }

    public List<ConstructionEquipment> getAll() {
        return constructionEquipmentRepository.findAll();
    }

    public ConstructionEquipment findByVIN(String vin) {
        return constructionEquipmentRepository.findByVin(vin);
    }

    public ConstructionEquipment editByVin(
            String vin,
            Map<String, Object> patchPayload
    ) throws JsonMappingException {

        ConstructionEquipment byVIN = findByVIN(vin);

        if (patchPayload.containsKey("id") || patchPayload.containsKey("vin"))
            throw new RuntimeException("One of the fields is not available for update.");

        ConstructionEquipment updatedValue = objectMapper.updateValue(byVIN, patchPayload);

        return constructionEquipmentRepository.save(updatedValue);
    }

    public void deleteByVin(String vin) {
        constructionEquipmentRepository.deleteByVin(vin);
    }
}
