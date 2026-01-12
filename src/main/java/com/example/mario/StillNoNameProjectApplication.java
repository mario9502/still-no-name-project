package com.example.mario;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StillNoNameProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(StillNoNameProjectApplication.class, args);
    }

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println("Hello World!");
		};
	}
}
