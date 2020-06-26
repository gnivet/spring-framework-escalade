package org.springframework.samples.escalade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;





//@ComponentScan(basePackages = "org.springframework.samples.escalade")
@SpringBootApplication
public class SpringFrameworkEscaladeApplication {
	private static final Logger logger = LoggerFactory.getLogger((SpringFrameworkEscaladeApplication.class));
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringFrameworkEscaladeApplication.class, args);
		 logger.info("#   #   #  P6 Spring Boot Escalade is starting... #   #   #  ");
	}

	
	
}



