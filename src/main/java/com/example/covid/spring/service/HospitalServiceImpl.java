package com.example.covid.spring.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.covid.spring.entity.Admin;
import com.example.covid.spring.entity.Hospital;
import com.example.covid.spring.exception.HospitalNotFoundException;
import com.example.covid.spring.repository.AdminRepository;
import com.example.covid.spring.repository.HospitalRepository;


@Service
public class HospitalServiceImpl implements IHospitalService
{
	@Autowired
	HospitalRepository hospitalRepository ;
	
	//1
	public List<Hospital> getAllHospital()
	{
		
		return hospitalRepository.findAll();
	}
	
	//2
	public Hospital addHospital( Hospital hospital)
	{
		
		return hospitalRepository.save(hospital);
	}
	
	//3
	public Hospital getHospitalById(int hospitalId)
	{
	Optional <Hospital> emp=hospitalRepository.findById(hospitalId);
	if(emp.isPresent()) {
		return emp.get();
	}
	else {
		return null;
	}
		
	}
     
	//4
	public Hospital updateHospitalById(int hospitalId, Hospital hop) throws HospitalNotFoundException
		{
	
	    Optional<Hospital> dbemp=hospitalRepository.findById(hospitalId);
		if(dbemp.isPresent())
			{
			return hospitalRepository.save(hop);
			}
		else 
			{
			throw new HospitalNotFoundException("Employee not found");
			}
		}

	//5
	public Hospital deleteHospitalById(int hospitalId) {
	
	 Optional <Hospital>hop=hospitalRepository.findById(hospitalId);
		if(hop.isPresent()) {
			hospitalRepository.deleteById(hospitalId);
		}else 
		{
			return null;
		}
		return hop.get();
		}

	
	//6
	public Hospital updateHospitalName(int hospitalId, String newName) {
		Optional<Hospital>hop=hospitalRepository.findById(hospitalId);
		if(hop.isPresent())
		{
			Hospital dbEmp=hop.get();
			dbEmp.setHospitalName(newName);
			return hospitalRepository.save(dbEmp);
			
		}
		else
		{
			return null;
		}
	}

	public Hospital updateHospitalName(int hospitalId, Hospital hospital) {
		
		Optional<Hospital>hop=hospitalRepository.findById(hospitalId);
		if(hop.isPresent())
		{
			Hospital dbEmp=hop.get();
			dbEmp.setHospitalName(hospital);
			return hospitalRepository.save(dbEmp);
			
		}
		else
		{
			return null;
		}
	}


 
}
