package com.example.mario;

import com.example.mario.dao.CoachDAOImpl;
import com.example.mario.model.VolleyballCoach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StillNoNameProjectApplication {

	private static final Logger log = LoggerFactory.getLogger(StillNoNameProjectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(StillNoNameProjectApplication.class, args);
    }

	@Bean
	public CommandLineRunner commandLineRunner(
			CoachDAOImpl coachDAO
	) {
		return args -> createCoach(coachDAO);
	}

	private void createCoach(CoachDAOImpl coachDAO) {

		log.info("Creating a new Coach entity...");
		VolleyballCoach volleyballCoach = new VolleyballCoach("John", "Doe", "john@doe.com");

		log.info("Saving the Coach entity...");
		coachDAO.save(volleyballCoach);
	}
}
