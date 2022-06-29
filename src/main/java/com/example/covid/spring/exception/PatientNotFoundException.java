package com.example.covid.spring.exception;

public class PatientNotFoundException extends Exception {
	public PatientNotFoundException(String message)
	{
		super(message);
	}
}
