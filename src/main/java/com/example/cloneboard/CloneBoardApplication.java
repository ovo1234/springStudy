package com.example.cloneboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class CloneBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloneBoardApplication.class, args);
	}

}
