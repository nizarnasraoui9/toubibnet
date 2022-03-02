package com.toubibnet.toubibnet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toubibnet.toubibnet.model.PasswordReset;

public interface PasswordResetRepository extends JpaRepository<PasswordReset, Long> {
	
	public PasswordReset findByToken(String token);

}
