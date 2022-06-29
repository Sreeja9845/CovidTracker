package com.example.covid.spring.exception;

public class AddressNotFoundException extends Exception {
	public AddressNotFoundException(String message)
	{
		super(message);
	}
}
