package com.example.covid.spring.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Login {

	@Id
	private int loginId;
	private String email;
    private String password;
    
    public Login(int loginId , String email, String password)
    {
  		this.loginId=loginId ;
  		this.email=email;
  		this.password=password;
  		
  		
  	}
}
