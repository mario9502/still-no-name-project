package com.example.mario.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebRestController {

    @GetMapping("/")
    public String index() {
        return "Hello world";
    }

    @GetMapping("/workout")
    public String workout() {
        return "Starting workout...";
    }

}
