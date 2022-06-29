package com.example.covid.spring.exception;

public class HospitalNotFoundException extends Exception
{
	public HospitalNotFoundException(String message)
	{
		super(message);
	}
}
