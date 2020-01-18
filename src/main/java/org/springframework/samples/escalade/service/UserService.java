package org.springframework.samples.escalade.service;

import javax.transaction.Transactional;

import org.springframework.samples.escalade.model.User;
import org.springframework.samples.escalade.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void saveMyUser(User user) {
		userRepository.save(user);
	}
}
