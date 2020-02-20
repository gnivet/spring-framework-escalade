package org.springframework.samples.escalade.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.escalade.model.Role;
import org.springframework.samples.escalade.model.User;
import org.springframework.samples.escalade.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	/*
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	*/
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByUsername(username);
		if (user == null) {

			return new org.springframework.security.core.userdetails.User(" ", " ", true, true, true, true,
					getGrantedAuthorities(Collections.singletonList("NOT_ALLOWED")));


		}
		Set<Role>roleList= new HashSet<>();
		roleList= user.getRoles();
		List<String> privileges = roleList.stream().map(x -> x.getName()).collect(Collectors.toList());
		
		return new org.springframework.security.core.userdetails.User(user.getUsername() , user.getPassword() , true, true, true, true,
				getGrantedAuthorities(privileges));
	}

	private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (String privilege : privileges) {
			authorities.add(new SimpleGrantedAuthority(privilege));
		}
		return authorities;
	}

}