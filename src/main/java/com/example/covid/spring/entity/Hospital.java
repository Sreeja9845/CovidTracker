package com.example.covid.spring.entity;

import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Hospital {
	@Id
	
	private int hospitalId;
	
	@NotNull(message="Name shouldn't be empty")
	private String hospitalName;
	
	@NotNull(message="Name shouldn't be empty")
	private String hospitalAddress;
	private String hospitalType;
	private int freeBeds;

	public Hospital(int hospitalId, String hospitalName, String hospitalAddress, String hospitalType, int freeBeds) {
		this.hospitalId = hospitalId;
		this.hospitalName = hospitalName;
		this.hospitalAddress = hospitalAddress;
		this.hospitalType = hospitalType;
		this.freeBeds = freeBeds;
	}
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "adminId")
	private Admin admin;
	

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "street")
	private Address address;
	
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "city")
	private Address addr;
	
	
	  @OneToMany(targetEntity=Address.class, cascade=CascadeType.ALL)
	  @JoinColumn(name="state_fk",referencedColumnName="hospitalId")
	  private List< Address>addrss;
	

}
