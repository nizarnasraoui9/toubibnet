package com.toubibnet.toubibnet.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtUserSignUpRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;
	
    private String firstName;
    private String lastName;
    private String email;
    private Integer phoneNumber;
    private String password;
	
}