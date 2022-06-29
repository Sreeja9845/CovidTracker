package com.example.covid.spring.entity;

import javax.persistence.Entity;

import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data

@NoArgsConstructor
public class Address
{

	@Id
	
  private int addrId;
  private String street;
  private String city;
  private String state;

  
  
  public Address(int addrId, String street, String city, String state)
  {
		this.addrId= addrId;
		this.street=street;
		this.city=city;
		this.state=state;
		
	}
  
}
