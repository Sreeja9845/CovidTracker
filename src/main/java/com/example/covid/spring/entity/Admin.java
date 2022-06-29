package com.example.covid.spring.entity;


import javax.persistence.Entity;

import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Admin
{
	@Id
	private int adminId;
	private String adminName;
	private long adminContactNo;
	
	public Admin(int adminId, String adminName, long adminContactNo)
	{
		this.adminId=adminId;
		this.adminName=adminName;
		this.adminContactNo=adminContactNo;
	}
}
