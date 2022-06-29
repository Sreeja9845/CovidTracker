package com.example.covid.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.covid.spring.entity.Patient;
import com.example.covid.spring.exception.PatientNotFoundException;
import com.example.covid.spring.service.IPatientService;

@RestController
public class PatientController
{
	@Autowired
	IPatientService patientServ;

	@GetMapping("/patient") ResponseEntity<List<Patient>> getAllPatient() 
	{
		List<Patient> listpatient =patientServ.getAllPatient();
		 return new
		ResponseEntity<>(listpatient, HttpStatus.OK);
	 }
	
	//adding
	@PostMapping("/patient")
	 ResponseEntity<Patient>addPatient(@Valid @RequestBody Patient patient)
	 {
	 Patient newPatient=patientServ.addPatient(patient);
	 return new
	  ResponseEntity<>(newPatient,HttpStatus.CREATED); 
	 }
	@PutMapping("/patient/{id}")
	ResponseEntity<Patient> updatePatientById(@RequestBody Patient pat ,@PathVariable("id") int patientId) throws PatientNotFoundException
	{
		Patient updatedPatient=patientServ.updatePatientById(patientId,pat);
		return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
	}
	
	@DeleteMapping("/patient/{id}")
	ResponseEntity<Patient >deletePatientById(@PathVariable ("id") int patientId)
	{
		Patient pat=patientServ.deletePatientById(patientId);
		return new ResponseEntity<>( pat, HttpStatus.OK);
	}

}
