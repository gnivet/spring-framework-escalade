package org.springframework.samples.escalade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@SpringBootApplication
//@ComponentScan({"/WEB-INF/jsp"})
@SpringBootApplication
//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SpringFrameworkEscaladeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFrameworkEscaladeApplication.class, args);
	}

}
