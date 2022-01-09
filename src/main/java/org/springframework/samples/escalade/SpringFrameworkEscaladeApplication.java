package org.springframework.samples.escalade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.samples.escalade.model.ApplicationMessage;
import org.springframework.samples.escalade.service.BusinessService;

//@ComponentScan(basePackages = "org.springframework.samples.escalade")
@SpringBootApplication
public class SpringFrameworkEscaladeApplication implements CommandLineRunner {

	@Autowired
	private BusinessService bs;

	static final Logger logger = LoggerFactory.getLogger((SpringFrameworkEscaladeApplication.class));

	public static void main(String[] args) {
		// logger.info("STARTING : Spring boot application starting");
		// logger.info("# # # P6 Spring Boot Escalade is starting... # # # ");
		SpringApplication.run(SpringFrameworkEscaladeApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// logger.info("EXECUTING : command line runner");
		ApplicationMessage am = bs.getApplicationMessage();
		System.out.println(am);

	}

}
