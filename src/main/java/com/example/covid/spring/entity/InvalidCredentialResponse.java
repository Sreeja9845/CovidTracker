package com.example.covid.spring.entity;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class InvalidCredentialResponse {
	 int status;
	    String message;
	    LocalDateTime timeStamp;
	    
}
