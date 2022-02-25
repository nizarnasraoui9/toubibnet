package com.toubibnet.toubibnet.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.toubibnet.toubibnet.repository.UserRepo;


@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepo userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserDetails user = userRepository.findByEmail(email);
		if(user==null)
			throw new UsernameNotFoundException("User does not exist");
		return user;
	}

}