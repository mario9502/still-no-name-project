package com.example.mario.controller;

import com.example.mario.service.CoachService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebRestController {

    public CoachService coachService;

    public WebRestController(
            CoachService coachService
    ) {
        this.coachService = coachService;
    }

    @GetMapping("/")
    public String index() {
        return "Hello world";
    }

    @GetMapping("/workout")
    public String workout() {
        return "Starting workout...";
    }

    @GetMapping("/getDailyWorkout")
    public String getDailyWorkout() {
        return coachService.getDailyWorkout();
    }

}
