package com.example.covid.spring.exception;

public class LoginNotFoundException  extends Exception{
	public LoginNotFoundException(String message)
	{
		super(message);
	}
}
