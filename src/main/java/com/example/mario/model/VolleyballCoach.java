package com.example.mario.model;

import org.springframework.stereotype.Component;

@Component
public class VolleyballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice blockage and attacks";
    }
}
