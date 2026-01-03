package com.example.mario.model;

import org.springframework.stereotype.Component;

@Component
public class BoxingCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice jabs and uppercuts";
    }
}
