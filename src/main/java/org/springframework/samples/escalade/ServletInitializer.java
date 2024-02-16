package org.springframework.samples.escalade;

import javax.servlet.Filter;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringFrameworkEscaladeApplication.class);
	}

	 private static final String SPRING_PROFILE = "jpa";

	    protected WebApplicationContext createRootApplicationContext() {
	        XmlWebApplicationContext rootAppContext = new XmlWebApplicationContext();
	        rootAppContext.setConfigLocations("classpath:spring/business-config.xml", "classpath:spring/tools-config.xml");
	        rootAppContext.getEnvironment().setDefaultProfiles(SPRING_PROFILE);
	        return rootAppContext;
	    }

	    protected WebApplicationContext createServletApplicationContext() {
	        XmlWebApplicationContext webAppContext = new XmlWebApplicationContext();
	        webAppContext.setConfigLocation("classpath:spring/mvc-core-config.xml");
	        return webAppContext;
	    }

	    protected String[] getServletMappings() {
	        return new String[]{"/"};
	    }

	    protected Filter[] getServletFilters() {
	        // Used to provide the ability to enter Chinese characters inside the Owner Form
	        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8", true);
	        return new Filter[]{characterEncodingFilter};
	    }

}
