package com.example.mario.model;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public final class VolleyballCoach implements Coach {

    public static final Logger log = LoggerFactory.getLogger(VolleyballCoach.class);

    public VolleyballCoach() {
        log.info(">>>>In constructor {}<<<<", this.getClass().getSimpleName());
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
}
