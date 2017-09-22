package com.afs.nats.stdapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.afs.nats.stdapp.model.User;
import com.afs.nats.stdapp.repository.UserRepository;

@Service
public class AuthenticatedUserService implements UserDetailsService {
	
	private UserRepository userRepository;

	@Autowired
	public AuthenticatedUserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("The user " + username + " does not exist");
		}
		return new AuthenticatedUser(user);
	}
}
