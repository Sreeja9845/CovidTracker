package com.example.covid.spring.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.covid.spring.entity.Hospital;
import com.example.covid.spring.exception.HospitalNotFoundException;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class HospitalServiceTest {

	@Autowired
	IHospitalService hospitalService;
	@Test
	@Order(1)
	void testAddHospital()
	{
		/*Hospital hospital=new Hospital();
		hospital.setHospitalId(0);
		hospital.setHospitalName("New Manasa Hospital");
		hospital.setHospitalAddresss("Devanahalli");
		hospital.setFreeBeds(10);
		hospital.setHospitalType("genral");
		*/
		/*Admin admin=new Admin();
		admin.setAdminId(4);
		admin.setAdminName("Ankitha");
		admin.setAdminContactNo(123456789);
		//hospital.setAdmin(admin);
		*/
		
		Hospital hospital=new Hospital(30,"Appollo","banglore","general",10);
	    Hospital newHospital=hospitalService.addHospital(hospital);
	    assertEquals("Appollo",newHospital.getHospitalName());
		
	}
	@Test
	@Order(2)
	void testUpdatHospital() throws HospitalNotFoundException
	{
		Hospital hospital=new Hospital(7,"Sushrusha","Banglore","general",5);
		Hospital hop=hospitalService.updateHospitalById(7,hospital);
		assertEquals(7,hop.getHospitalId());
		
	}
	@Test
	@Disabled
	@Order(3)
	void testDeleteHospital()
	{
		Hospital hospital=new Hospital(16,"manipal","banglore","general",10);
		Hospital hop=hospitalService.deleteHospitalById(16);
		assertEquals(16,hop.getHospitalId());
	}
}
