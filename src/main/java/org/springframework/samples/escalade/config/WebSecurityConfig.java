package org.springframework.samples.escalade.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.samples.escalade.service.MyUserDetailsService;
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
	public UserDetailsService myUserDetailsService() {
		return new MyUserDetailsService();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserDetailsService userDetailsService = myUserDetailsService();
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();

		// The pages does not require login
		http.authorizeRequests().antMatchers("/", "/login", "/register", "/logout", "/registerSuccessfulPage.jsp", "welcome.jsp")
				.permitAll();

		// /userInfo page requires login as ROLE_USER or ROLE_ADMIN.
		// If no login, it will redirect to /login page.
		http.authorizeRequests().antMatchers("/userInfo").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/areas").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/users").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/escalade/areas").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/areas/toposList").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/escalade/areas/toposList").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/escalade/users/find").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/userAccountInfo").hasAnyRole("USER", "ADMIN");

		// For ADMIN only. /users/find
		http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN");

		// When the user has logged in as XX.
		// But access a page that requires role YY,
		// AccessDeniedException will be thrown.
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

		// Config for Login Form
		
	}

}
