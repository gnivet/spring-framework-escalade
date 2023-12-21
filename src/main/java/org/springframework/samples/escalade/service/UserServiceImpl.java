package org.springframework.samples.escalade.service;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.samples.escalade.model.Role;
import org.springframework.samples.escalade.model.User;
import org.springframework.samples.escalade.repository.RoleRepository;
import org.springframework.samples.escalade.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    
   /*
    * 	
    */
    //GNI
    
    @Bean
    public SessionLocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.US);
        return slr;
    }
    
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
    
    @Autowired
    private BCryptPasswordEncoder bCryptPassword;
    @Bean
    BCryptPasswordEncoder bCryptPassword()
    {
    	return new BCryptPasswordEncoder();
    }
    
    
    
    //GNI
   
    
    public void save(User user) {
        user.setPassword(bCryptPassword.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
    public List<Role> findByRolename(String role) {
    	return roleRepository.findAll();
    }
	@Override
	public void save(org.springframework.security.core.userdetails.User user) {
		// TODO Auto-generated method stub
		
	}
}