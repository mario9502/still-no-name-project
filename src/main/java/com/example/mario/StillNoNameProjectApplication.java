package com.example.mario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StillNoNameProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(StillNoNameProjectApplication.class, args);
	}


    public void printHelloWorld() {
        System.out.println("Hello World");
    }

}
