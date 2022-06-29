package com.example.covid.spring.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.covid.spring.entity.Address;
import com.example.covid.spring.entity.Admin;

@SpringBootTest
public class AdminServiceTest
{
	@Autowired
	IAdminService adminService;
	@Test
	@Order(1)
	void testAddAdmin()
	{
		Admin admin=new Admin(6,"Likitha",112345678);
	    Admin newAdmin=adminService.addAdmin(admin);
	    assertEquals("Likitha",newAdmin.getAdminName());
	  
	}
	@Test
	@Order(2)
	void testUpdatAdmin()
	{
		Admin admin=new Admin(3,"Manjula",1123456784);
		Admin newAdmin=adminService.updateAdminName(3,"Manjula");
		assertEquals("Manjula",admin.getAdminName());
		
	}
	@Test
	@Order(3)
	void testDeleteAdmin()
	{
	Admin admin=new Admin(4,"Ankithasree",12345677);
	Admin newAdmin=adminService.deleteAdmin(4);
	assertEquals(4,admin.getAdminId());
	}
}
