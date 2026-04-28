package com.example.mario.service;

import com.example.mario.repository.ConstructionMachineRepo;
import com.example.mario.model.Machine;
import com.example.mario.model.ConstructionEquipment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConstructionMachineService {

    private final Machine machine;
    private final ConstructionMachineRepo constructionRepo;

    public ConstructionMachineService(
            @Qualifier("constructionEquipment") Machine machine,
            ConstructionMachineRepo constructionMachineRepo
    ) {
        this.machine = machine;
        this.constructionRepo = constructionMachineRepo;
    }

    public int getWorkingHours() {
        return machine.getWorkingHours();
    }

    public void addConstructionMachine(ConstructionEquipment machine) {
        constructionRepo.save(machine);
    }

    public List<Machine> getAll() {
        return constructionRepo.findAll();
    }

    public Machine findByVIN(String email) {
        return constructionRepo.findByVIN(email);
    }
}
