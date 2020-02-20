package org.springframework.samples.escalade.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.samples.escalade.service.UserDetailsServiceImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserDetailsService userDetailsService = userDetailsService();
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
   
	
	
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();

		// The pages does not require login
		/*
		http.authorizeRequests().antMatchers("/", "/users/login", "/logout", "/welcome",
				"/users/new" , "/users/registration" , "/areas/new" , "/areas", "/areas/find", "/areas/new", "/comments/find", "/comments/new" , "/comments" , "/zones/new")
				.permitAll();
		*/		
		http.authorizeRequests().antMatchers("/", "/login", "/logout" , "/users/registration", "/users/login" , "/welcome").permitAll();
		// /userInfo page requires login as ROLE_USER or ROLE_ADMIN.
		// If no login, it will redirect to /login page.
		http.authorizeRequests().antMatchers("/areas").hasAnyRole("USER", "ADMIN");
		//http.authorizeRequests().antMatchers("/users").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/escalade/areas").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/areas/sitesList").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/escalade/areas/sitesList").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/escalade/users/find").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/escalade/comments/find").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/users/userInfo").hasAnyRole("USER", "ADMIN");
		//http.authorizeRequests().antMatchers("/users/registration").hasAnyRole("USER", "ADMIN");
		http.logout().logoutUrl("/users/logout").logoutSuccessUrl("/welcome");

		// For ADMIN only. /users/find
		http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN");

		// When the user has logged in as XX.
		// But access a page that requires role YY,
		// AccessDeniedException will be thrown.
		//http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

		// Config for Login Form
		
	}

}
