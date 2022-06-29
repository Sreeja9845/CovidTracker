package com.example.covid.spring.service;

import java.util.List;

import com.example.covid.spring.entity.Hospital;
import com.example.covid.spring.exception.HospitalNotFoundException;


public interface IHospitalService
{

	List<Hospital> getAllHospital();
	Hospital getHospitalById(int hospitalId);
	Hospital addHospital(Hospital emp);
	Hospital updateHospitalById(int hospitalId,Hospital hop) throws HospitalNotFoundException;
	Hospital deleteHospitalById(int hospitalId);
	Hospital updateHospitalName(int HospitalId, String newName);
	
}
