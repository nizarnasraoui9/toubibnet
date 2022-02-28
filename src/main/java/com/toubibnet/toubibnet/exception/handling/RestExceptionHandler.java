package com.toubibnet.toubibnet.exception.handling;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.toubibnet.toubibnet.exception.UserAlreadyExistsException;
@EnableWebMvc
@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(UserAlreadyExistsException.class)
	protected ResponseEntity<?> handleUserAlreadyExistsException(UserAlreadyExistsException e) {
		String error = "user already exists";
		return buildResponseEntity(new ApiError(HttpStatus.CONFLICT, error, e));
	}

	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}

	//other exception handlers below

}
