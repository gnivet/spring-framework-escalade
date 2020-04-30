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
		http.authorizeRequests().antMatchers("/", "/login", "/logout" , "/users/registration", "/users/login" , "/welcome" ,"/error/error").permitAll();
		// /userInfo page requires login as ROLE_USER or ROLE_ADMIN.
		// If no login, it will redirect to /login page.
		http.authorizeRequests().antMatchers("/areas/").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/areas/new").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/way").hasAnyRole("USER", "ADMIN");
		//http.authorizeRequests().antMatchers("/users").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/areas/find").hasAnyRole("USER", "ADMIN");		
		http.authorizeRequests().antMatchers("/areas/sitesList").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/areas/sitesList").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/users/find").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/users").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/comments/find").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/users/userInfo").hasAnyRole("USER", "ADMIN");
		//http.authorizeRequests().antMatchers("/users/registration").hasAnyRole("USER", "ADMIN");
		http.logout().logoutUrl("/users/logout").logoutSuccessUrl("/welcome");
		http.authorizeRequests().antMatchers("/users/createOrUpdateUserForm").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/sites/new").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/areas/*/sites/new").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/sites/").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/sites/find").hasAnyRole("USER", "ADMIN");		
		http.authorizeRequests().antMatchers("/zones/new").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/sitetypes/new").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/sitetypes/find").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/sitetypes/").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/sitetypes/edit").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/areas/sitetypesList").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/siteTypes/siteTypeDetails").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/areas/findSites").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/escalade/areas/findAreas").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/escalade/areas/findSites").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/escalade/sites/findSites").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/escalade/areas").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/lengths/new").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/lengths/").hasAnyRole("USER", "ADMIN");		
		http.authorizeRequests().antMatchers("/lengths/find").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/lengths/lengthsList").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/escalade/ways/findLengths").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/points/").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/points/find").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/sites/*/comments/new").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/points/").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/points/find").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/lengths/*/points/new").hasAnyRole("USER", "ADMIN");			
		http.authorizeRequests().antMatchers("/points/new").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/sites/*/zones/new").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/zones/find").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/dashboard").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/topos/").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/topos/new").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/topos/findTopos").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("topos/toposList").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/topoBkgs/").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/topoBkgs/*").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/topoBkgs/new").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/topoBkgs/find").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/topoBkgs/findTopoBkgs").hasAnyRole("USER", "ADMIN");
		
		
		//	http.authorizeRequests().antMatchers("/areas/").hasAnyRole("USER", "ADMIN");			
		// For ADMIN only. /users/find
		http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN");

		// When the user has logged in as XX. 
		// But access a page that requires role YY,
		// AccessDeniedException will be thrown.
		//http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

		// Config for Login Form
		
	}

}
