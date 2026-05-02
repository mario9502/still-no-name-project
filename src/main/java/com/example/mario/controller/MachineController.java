package com.example.mario.controller;

import com.example.mario.model.Machine;
import com.example.mario.model.ConstructionEquipment;
import com.example.mario.service.ConstructionMachineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class MachineController {

    private static final Logger log = LoggerFactory.getLogger(MachineController.class);
    public ConstructionMachineService constructionMachineService;

    public MachineController(
            ConstructionMachineService constructionMachineService
    ) {
        this.constructionMachineService = constructionMachineService;
    }

    @GetMapping("/allConstruction")
    public List<Machine> getAllConstruction() {
        return constructionMachineService.getAll();
    }

    @GetMapping("/getWorkingHours")
    public int getWorkingHours() {
        return constructionMachineService.getWorkingHours();
    }

    @GetMapping("/getConstructionByVin/{vin}")
    public Machine getConstructionByVIN(
            @PathVariable String vin
    ) {
        return constructionMachineService.findByVIN(vin);
    }

    @PostMapping("/addMachine")
    public void addMachine(@RequestBody ConstructionEquipment machine) {
        constructionMachineService.addConstructionMachine(machine);
    }

}
