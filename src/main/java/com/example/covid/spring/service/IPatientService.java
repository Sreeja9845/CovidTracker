package com.example.covid.spring.service;

import java.util.List;

import javax.validation.Valid;

import com.example.covid.spring.entity.Patient;
import com.example.covid.spring.exception.PatientNotFoundException;

public interface IPatientService
{

	List<Patient> getAllPatient();

	Patient addPatient(@Valid Patient patient);

	Patient updatePatientById(int patientId, Patient pat) throws PatientNotFoundException;

	Patient deletePatientById(int patientId);

}
