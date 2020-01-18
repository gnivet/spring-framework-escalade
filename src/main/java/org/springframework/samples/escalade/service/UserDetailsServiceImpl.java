package org.springframework.samples.escalade.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.escalade.dao.RoleDAO;
import org.springframework.samples.escalade.dao.UserDAO;
import org.springframework.samples.escalade.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
 
	@Autowired
    private UserDAO UserDAO;
 
    @Autowired
    private RoleDAO RoleDAO;
 
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User User = this.UserDAO.findUserAccount(userName);
 
        if (User == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }
 
        System.out.println("Found User: " + User);
 
        // [ROLE_USER, ROLE_ADMIN,..]
        List<String> roleNames = this.RoleDAO.getRoleNames(User.getUserId());
 
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roleNames != null) {
            for (String role : roleNames) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }
 
        UserDetails userDetails = (UserDetails) new User();
 
        return userDetails;
    }
    
    
    @Autowired
    private EntityManager entityManager;
   
    public void save(User user) {
    	
    	
    	String encrytedPassword = BCrypt.hashpw(user.getEncrytedPassword(), BCrypt.gensalt())	;		
    	user.getUserName();
    	user.setEncrytedPassword(encrytedPassword);
    	if (user.getUserId() == null) {
    		this.entityManager.persist(user);
    	} else {
    		this.entityManager.merge(user);
    	}

    } 
    
 
    /*
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public String findLoggedInUsername() {
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (userDetails instanceof UserDetails) {
            return ((UserDetails)userDetails).getUsername();
        }

        return null;
    }
    
    @Autowired    
    public void autoLogin(String username, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            logger.debug(String.format("Auto login %s successfully!", username));
        }
    }
   */
    
    
}