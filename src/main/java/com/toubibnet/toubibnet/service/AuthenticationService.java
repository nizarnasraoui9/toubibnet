package com.toubibnet.toubibnet.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.toubibnet.toubibnet.model.JwtRequest;
import com.toubibnet.toubibnet.model.User;
import com.toubibnet.toubibnet.repository.UserRepo;
@Service
public class AuthenticationService {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepo userRepository;


	public void authenticate(JwtRequest authRequest) throws Exception {
		Objects.requireNonNull(authRequest.getEmail());
		Objects.requireNonNull(authRequest.getPassword());

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(),authRequest.getPassword()));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	public void signUp(JwtRequest authRequest) {
		User user = new User();
		user.setEmail(authRequest.getEmail());
		user.setFirstName(authRequest.getNickname());
		user.setPassword(passwordEncoder.encode(authRequest.getPassword()));
		userRepository.save(user);
	}

}
