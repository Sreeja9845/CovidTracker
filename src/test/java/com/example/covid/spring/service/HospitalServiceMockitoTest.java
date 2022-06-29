package com.example.covid.spring.service;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.covid.spring.entity.Hospital;
import com.example.covid.spring.exception.HospitalNotFoundException;
import com.example.covid.spring.repository.HospitalRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class HospitalServiceMockitoTest {
	
	//create instance of class and injects mocks that are created 
	//Hear we are using for inject service dependency we are using this injectmocks
	
@InjectMocks
HospitalServiceImpl hospitalServ;

//insted of repo we are using this//this act as a database to us

@MockBean

HospitalRepository hospitalRepository;

//bfr evry test case this perticular mthd will call

@BeforeEach
void init()
{
	MockitoAnnotations.openMocks(this);
}
//1 get 
@Test 
void testGetHospitalById() throws HospitalNotFoundException
{
	Hospital hospital=new Hospital(40,"manipal","banglore","super speciality",10);
	Mockito.when(hospitalRepository.findById(40)).thenReturn(Optional.of(hospital));
	Hospital hop=hospitalServ.getHospitalById(40);
	assertEquals(40,hop.getHospitalId());
	assertEquals("manipal",hop.getHospitalName());
}
//2 update
void testUpdateHospitalByName() throws HospitalNotFoundException {
	Hospital hospital=new Hospital(40,"manasa","tumkur","nursing home",5);
	Mockito.when(hospitalRepository.findById(40)).thenReturn(Optional.of(hospital));
	Mockito.when(hospitalRepository.save(hospital)).thenReturn(hospital);
	Hospital hop=hospitalServ.updateHospitalById(40, hospital);

}

}
