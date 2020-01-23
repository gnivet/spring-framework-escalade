package org.springframework.samples.escalade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
@ComponentScan({"/WEB-INF/views/jsp"})
@SpringBootApplication
public class SpringFrameworkEscaladeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFrameworkEscaladeApplication.class, args);
	}

}
