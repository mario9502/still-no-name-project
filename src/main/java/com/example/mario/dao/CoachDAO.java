package com.example.mario.dao;

import com.example.mario.model.Coach;
import com.example.mario.model.VolleyballCoach;

import java.util.List;

public interface CoachDAO {

    void save(VolleyballCoach coach);

    List<Coach> findAllByLastName(String lastName);

    Coach update(Coach coach);

    List<Coach> findAll();
}
