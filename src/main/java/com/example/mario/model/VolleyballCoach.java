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
@Table(name = "coach")
public class VolleyballCoach implements Coach {

    public static final Logger log = LoggerFactory.getLogger(VolleyballCoach.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    public VolleyballCoach() {
        log.info(">>>>In constructor {}<<<<", this.getClass().getSimpleName());
    }

    public VolleyballCoach(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice blockage and attacks";
    }

    @PostConstruct
    public void doMyStartupThings() {
        log.info("Successfully constructed: {}", getClass().getSimpleName());
    }

    @PreDestroy
    public void doMyDestroyStuff() {
        log.info("Destroying...: {}", getClass().getSimpleName());
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (!lastName.isBlank()) {
            this.lastName = lastName;
        } else {
            log.warn("NULL value can't be assigned");
        }
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "VolleyballCoach{" +
                "email='" + email + '\'' +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
