package com.toubibnet.toubibnet.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.toubibnet.toubibnet.config.JwtTokenUtil;
import com.toubibnet.toubibnet.model.JwtDoctorSignUpRequest;
import com.toubibnet.toubibnet.model.JwtResponse;
import com.toubibnet.toubibnet.model.JwtSignInRequest;
import com.toubibnet.toubibnet.model.JwtUserSignUpRequest;
import com.toubibnet.toubibnet.service.AuthenticationService;

@CrossOrigin
@RestController
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService userDetailsService;
	

	@RequestMapping(value = "/auth/signin", method = RequestMethod.POST)
	public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestBody JwtSignInRequest authenticationRequest)
			throws Exception {

		authenticationService.authenticate(authenticationRequest);

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getEmail());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return new ResponseEntity<JwtResponse>(new JwtResponse(token,userDetails), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/auth/signup/user", method = RequestMethod.POST)
	public void signUpUser(@RequestBody JwtUserSignUpRequest authenticationRequest) {
		
		authenticationService.signUpUser(authenticationRequest);
		
	}
	@RequestMapping(value = "/auth/signup/doctor", method = RequestMethod.POST)
	public void signUpDoctor(@RequestBody JwtDoctorSignUpRequest authenticationRequest) {
		
		authenticationService.signUpDoctor(authenticationRequest);
		
		
	}

}
