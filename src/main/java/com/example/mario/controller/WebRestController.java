package com.example.mario.controller;

import com.example.mario.model.Coach;
import com.example.mario.model.VolleyballCoach;
import com.example.mario.service.CoachService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class WebRestController {

    private static final Logger log = LoggerFactory.getLogger(WebRestController.class);
    public CoachService coachService;

    public WebRestController(
            CoachService coachService
    ) {
        this.coachService = coachService;
    }

    @GetMapping("/allCoaches")
    public List<Coach> getAllCoaches() {
        return coachService.getAll();
    }

//    @GetMapping("/getCoachByEmail/{email}")
//    public Coach getCoachByMail(
//            @RequestParam String email
//    ) {
//        coachService.findByEmail(email) {
//
//        }
//    }

    @GetMapping("/getDailyWorkout")
    public String getDailyWorkout() {
        return coachService.getDailyWorkout();
    }

    @PostMapping("/addCoach")
    public void addCoach(@RequestBody VolleyballCoach coach) {
        coachService.addCoach(coach);
    }

}
