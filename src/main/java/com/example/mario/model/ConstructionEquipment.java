package com.example.mario.model;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "construction")
public class ConstructionEquipment implements Machine {

    public static final Logger log = LoggerFactory.getLogger(ConstructionEquipment.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "vin")
    private String vin;

    @Column(name = "working_hours")
    private int workingHours;

    public ConstructionEquipment() {
        log.info(">>>>In constructor {}<<<<", this.getClass().getSimpleName());
    }

    public ConstructionEquipment(String brand, String model, String vin) {
        this.brand = brand;
        this.model = model;
        this.vin = vin;
    }

    @Override
    public int getWorkingHours() {
        return workingHours;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Override
    public String toString() {
        return "ConstructionEquipment{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", vin='" + vin + '\'' +
                ", workingHours=" + workingHours +
                '}';
    }

    @PostConstruct
    public void doMyStartupThings() {
        log.info("Successfully constructed: {}", getClass().getSimpleName());
    }

    @PreDestroy
    public void doMyDestroyStuff() {
        log.info("Destroying...: {}", getClass().getSimpleName());
    }
}
