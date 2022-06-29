package com.example.covid.spring.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import com.example.covid.spring.entity.Address;

import com.example.covid.spring.exception.AddressNotFoundException;
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class AddressServiceTest
{
	@Autowired
	IAddressService addrServ;
	@Test
	@Order(1)
	void testAddAddress(){
Address address=new Address(1,"Banashankri","Banglore","Karnataka");
Address newAddress=addrServ.addAddress(address);
assertEquals("Banashankri",newAddress.getStreet());
	}
	
	@Test
	@Order(2)
	void testUpdatAddress() throws AddressNotFoundException 
	{
		Address address=new Address(8,"T T Nagar","Banglore","Karnataka");
		Address addr=addrServ.updateAddressById(8,address);
		assertEquals(8,addr.getAddrId());
		
	}
	@Test
	@Order(3)
	@Disabled
	void testDeleteAddress()
	{
		Address addr=addrServ.deleteAddress(10);
		assertEquals(10,addr.getAddrId());
	}
}
