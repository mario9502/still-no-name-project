package com.example.mario.service;

import com.example.mario.model.Coach;
import org.springframework.stereotype.Service;

@Service
public class CoachService {

    private final Coach coach;

    public CoachService(
            Coach coach
    ) {
        this.coach = coach;
    }

    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }
}
