package com.toubibnet.toubibnet.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.toubibnet.toubibnet.config.JwtTokenUtil;
import com.toubibnet.toubibnet.model.JwtRequest;
import com.toubibnet.toubibnet.model.JwtResponse;
import com.toubibnet.toubibnet.repository.UserRepo;
import com.toubibnet.toubibnet.service.AuthenticationService;


@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private UserRepo userRepository;

	@RequestMapping(value = "/auth/signin", method = RequestMethod.POST)
	public JwtResponse createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
			throws Exception {

		authenticationService.authenticate(authenticationRequest);

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getEmail());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return new JwtResponse(token,userRepository.findByEmail(authenticationRequest.getEmail()));
	}
	
	@RequestMapping(value = "/auth/signup", method = RequestMethod.POST)
	public void signUp(@RequestBody JwtRequest authenticationRequest) {
		
		authenticationService.signUp(authenticationRequest);
		
	}
}
