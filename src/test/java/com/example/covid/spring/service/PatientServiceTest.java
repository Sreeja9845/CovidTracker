package com.example.covid.spring.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.covid.spring.entity.Address;
import com.example.covid.spring.entity.Patient;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class PatientServiceTest
{
	@Autowired
	IPatientService patientServ;
  /*@Test
	@Order(1)
	void testAddPatient(){
   Patient patient=new Patient(1,"Sreeja",23, 2022-06-28, 2022-06-29,"cold");
 Patient newPatient=patientServ.addPatient(patient);
 assertEquals(1,newPatient.getPatientId());
	}
*/
	
	@Test
	@Order(1)
	
	void testDeletePatient()
	{
		Patient pat=patientServ.deletePatientById(2);
		assertEquals(2,pat.getPatientId());
	}
}
