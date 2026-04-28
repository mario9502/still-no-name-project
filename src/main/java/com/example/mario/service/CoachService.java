package com.example.mario.service;

import com.example.mario.repository.CoachDAOImpl;
import com.example.mario.model.Coach;
import com.example.mario.model.VolleyballCoach;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachService {

    private final Coach coach;
    private final CoachDAOImpl coachDAO;

    public CoachService(
            @Qualifier("volleyballCoach") Coach coach,
            CoachDAOImpl coachDAO
    ) {
        this.coach = coach;
        this.coachDAO = coachDAO;
    }

    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }

    public void addCoach(VolleyballCoach coach) {
        coachDAO.save(coach);
    }

    public List<Coach> getAll() {
        return coachDAO.findAll();
    }

    public Coach findByEmail(String email) {
        return coachDAO.findByEmail(email);
    }
}
