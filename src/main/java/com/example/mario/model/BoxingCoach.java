package com.example.mario.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BoxingCoach implements Coach{

    private static final Logger log = LoggerFactory.getLogger(BoxingCoach.class);

    public BoxingCoach() {
        log.info(">>>>In constructor {}<<<<", this.getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice jabs and uppercuts";
    }
}
