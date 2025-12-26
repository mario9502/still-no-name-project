package com.example.mario.model;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice short and long passes.";
    }
}
