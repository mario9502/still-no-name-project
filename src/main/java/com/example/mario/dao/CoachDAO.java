package com.example.mario.dao;

import com.example.mario.model.Coach;
import java.util.List;

public interface CoachDAO {

    void save(Coach coach);

    List<Coach> findAllByLastName(String lastName);

    Coach update(Coach coach);
}
