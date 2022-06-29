package com.example.covid.spring.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.covid.spring.entity.ErrorResponse;

public class LoginExceptionHandler {
	@ExceptionHandler(LoginNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(LoginNotFoundException exception) {
		ErrorResponse error = new ErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(LocalDateTime.now());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<ErrorResponse> handleException(InvalidCredentialsException exception) {
		ErrorResponse error = new ErrorResponse();
		error.setStatus(HttpStatus.UNAUTHORIZED.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(LocalDateTime.now());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

	}
}
