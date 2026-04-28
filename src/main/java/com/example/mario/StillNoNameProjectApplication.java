package com.example.mario;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StillNoNameProjectApplication {

	private static final Logger log = LoggerFactory.getLogger(StillNoNameProjectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(StillNoNameProjectApplication.class, args);
    }
}
