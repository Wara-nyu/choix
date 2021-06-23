package com.team.choix;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChoixApplication {
	
//	private static final Logger LOGGER = LogManager.getLogger(ChoixApplication.class);
	
	public static void main(String[] args) {
//		LOGGER.debug("debuging");
		SpringApplication.run(ChoixApplication.class, args);
	}

}
