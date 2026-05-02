package com.example.mario.controller;

import com.example.mario.model.Machine;
import com.example.mario.model.ConstructionEquipment;
import com.example.mario.service.ConstructionEquipmentService;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ConstructionEquipmentController {

    private static final Logger log = LoggerFactory.getLogger(ConstructionEquipmentController.class);
    public ConstructionEquipmentService constructionEquipmentService;

    public ConstructionEquipmentController(
            ConstructionEquipmentService constructionEquipmentService
    ) {
        this.constructionEquipmentService = constructionEquipmentService;
    }

    @GetMapping("/constructionEquipments")
    public List<ConstructionEquipment> getAllConstruction() {
        return constructionEquipmentService.getAll();
    }

    @GetMapping("/constructionEquipments/{vin}")
    public Machine getConstructionByVIN(
            @PathVariable String vin
    ) {
        return constructionEquipmentService.findByVIN(vin);
    }

    @PostMapping("/constructionEquipments")
    public ConstructionEquipment addConstruction(
            @RequestBody ConstructionEquipment machine
    ) {
       return constructionEquipmentService.addConstructionMachine(machine);
    }

    @PatchMapping("/constructionEquipments/{vin}")
    public Machine editById(
            @PathVariable String vin,
            @RequestBody Map<String, Object> patchPayload
    ) throws JsonMappingException {
       return constructionEquipmentService.editByVin(vin, patchPayload);
    }

    @DeleteMapping("/constructionEquipments/{vin}")
    public void deleteByVin(@PathVariable String vin) {
        constructionEquipmentService.deleteByVin(vin);
    }
}
