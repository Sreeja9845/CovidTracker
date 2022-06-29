package com.example.covid.spring.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.covid.spring.entity.Patient;
import com.example.covid.spring.exception.PatientNotFoundException;
import com.example.covid.spring.repository.PatientRepository;
@Service
public class PatientServiceImpl implements IPatientService {
@Autowired
PatientRepository patientRepo;
	@Override
	public List<Patient> getAllPatient() {
		
	return patientRepo.findAll();
	}

	@Override
	public Patient addPatient(@Valid Patient patient) {
		
		return patientRepo.save(patient);
	}

	@Override
	public Patient updatePatientById(int patientId, Patient pat) throws PatientNotFoundException {
		

		
	    Optional<Patient> dbpat=patientRepo.findById(patientId);
		if(dbpat.isPresent())
			{
			return patientRepo.save(pat);
			}
		else 
			{
			throw new PatientNotFoundException("Employee not found");
			}
		
	}

	public Patient deletePatientById(int patientId) {

		
		 Optional <Patient>pat=patientRepo.findById(patientId);
			if(pat.isPresent()) {
				patientRepo.deleteById(patientId);
			}else 
			{
				return null;
			}
			return pat.get();
			
		
	}

	

}
