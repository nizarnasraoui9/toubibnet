package com.toubibnet.toubibnet.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PasswordReset {
	private static long EXPIRATION_PERIOD= 24 * 60 * 60;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	private Long expirationDate;
	private String token;
	
	@OneToOne
	private User user;

	public PasswordReset() {
		this.timestamp = LocalDateTime.now();
		this.expirationDate=System.currentTimeMillis()+EXPIRATION_PERIOD*1000;
	}
	public PasswordReset(User user,String token) {
		this();
		this.user=user;
		this.token=token;
	}

}
