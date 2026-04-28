package com.example.mario;

import com.example.mario.repository.CoachDAOImpl;
import com.example.mario.model.Coach;
import com.example.mario.model.VolleyballCoach;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StillNoNameProjectApplication {

	private static final Logger log = LoggerFactory.getLogger(StillNoNameProjectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(StillNoNameProjectApplication.class, args);
    }

	//@Bean
	public CommandLineRunner commandLineRunner(
			CoachDAOImpl coachDAO
	) {
		return args -> createMultipleCoaches(coachDAO);
	}

	private void updateCoachLastName(CoachDAOImpl coachDAO) {
		Coach doe = coachDAO.findAllByLastName("Cena").getFirst();

		if (doe instanceof VolleyballCoach volleyballCoach) {
			volleyballCoach.setLastName("Doe");

			Coach updatedCoach = coachDAO.update(volleyballCoach);
			log.info(">>>>>>>>>>>>>>>Updated last name of coach<<<<<<<<<<<<<<<");
			log.info(">>>>>>>>>>>>>>>{}<<<<<<<<<<<<<<<", updatedCoach);
		}
	}

	private void findAllByLastName(CoachDAOImpl coachDAO) {

		List<Coach> coachList = coachDAO.findAllByLastName("Doe");

		coachList.forEach(coach -> {
					if (coach instanceof VolleyballCoach volleyballCoach) {
						log.info(">>>>>>>>>>>>>{}<<<<<<<<<<<<<<", volleyballCoach);
					}
				}
		);
	}

	private void createMultipleCoaches(CoachDAOImpl coachDAO) {

		log.info("Creating a new Coach entity...");
		VolleyballCoach volleyballCoach1 = new VolleyballCoach("John", "Doe", "john@doe.com");
		VolleyballCoach volleyballCoach2 = new VolleyballCoach("Paul", "Lewinsky", "paul@doe.com");
		VolleyballCoach volleyballCoach3 = new VolleyballCoach("Steve", "Harrington", "steve@doe.com");

		log.info("Saving the Coach entity...");
		coachDAO.save(volleyballCoach1);
		coachDAO.save(volleyballCoach2);
		coachDAO.save(volleyballCoach3);
	}

	private void createCoach(CoachDAOImpl coachDAO) {

		log.info("Creating a new Coach entity...");
		VolleyballCoach volleyballCoach = new VolleyballCoach("John", "Doe", "john@doe.com");

		log.info("Saving the Coach entity...");
		coachDAO.save(volleyballCoach);

        log.info("Successfully create coach with ID: {}", volleyballCoach.getId());
	}
}
