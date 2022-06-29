package com.example.covid.spring.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.covid.spring.entity.Hospital;

import com.example.covid.spring.exception.HospitalNotFoundException;
import com.example.covid.spring.service.IHospitalService;

@RestController
public class HospitalController
{
	@Autowired
	IHospitalService hospitalService ;
	
	@GetMapping("/hospital") ResponseEntity<List<Hospital>> getAllHospital() 
	{
		List<Hospital> listHospital =hospitalService.getAllHospital();
		 return new
		ResponseEntity<>(listHospital, HttpStatus.OK);
	 }
	
	//adding
	@PostMapping("/hospital")
	 ResponseEntity<Hospital>addHospital(@Valid @RequestBody Hospital hospital)
	 {
	 Hospital newHospital= hospitalService.addHospital(hospital);
	 return new
	  ResponseEntity<>(newHospital,HttpStatus.CREATED); 
	 }
	@GetMapping("/hospital/{id}")
	ResponseEntity<Hospital>getHospitalById(@PathVariable("id") int hospitalId)
	{
		Hospital hop=hospitalService.getHospitalById(hospitalId);
		return new ResponseEntity<>(hop,HttpStatus.OK );
	}
	
	//Updating by Id
	@PutMapping("/hospital/{id}")
	ResponseEntity<Hospital> updateHospitalById(@RequestBody Hospital hop ,@PathVariable("id") int hospitalId) throws HospitalNotFoundException
	{
		Hospital updatedHospital=hospitalService.updateHospitalById(hospitalId,hop);
		return new ResponseEntity<>(updatedHospital , HttpStatus.OK);
	}
	
	@DeleteMapping("/hospital/{id}")
	ResponseEntity<Hospital >deleteHospitalById(@PathVariable ("id") int hospitalId)
	{
		Hospital hop=hospitalService.deleteHospitalById(hospitalId);
		return new ResponseEntity<>(hop , HttpStatus.OK);
	}
	
	//update hospital by name
	@PatchMapping("/hospital/{id}")
	ResponseEntity<Hospital> updateHospitalName(@PathVariable("id") int hospitalId, @RequestBody String newName)
	{
		Hospital updatedHospital=hospitalService.updateHospitalName(hospitalId, newName);
	       return new ResponseEntity<>(updatedHospital,HttpStatus.OK);
	}
	
}
