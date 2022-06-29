package com.example.covid.spring.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.covid.spring.entity.Login;
import com.example.covid.spring.exception.LoginNotFoundException;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class LoginServiceTest {
	@Autowired
	ILoginService loginServ;
	@Test
	@Order(1)
	void testAddLogin(){
Login login=new Login(10,"ANki@gmail.com","sdf234");
Login newLogin=loginServ.addlogin(login);
assertEquals("ANki@gmail.com",newLogin.getEmail());
	}
	
	@Test
	@Order(2)
	void testUpdatLogin() throws LoginNotFoundException 
	{
		Login login=new Login(101,"asdfg@lkjb.com","wefg");
		Login newlog=loginServ.updateLoginById(login,101);
		assertEquals(101,newlog.getLoginId());
		
	}
	@Test
	@Order(3)
	@Disabled
	void testDeleteAddress()
	{
		Login login=loginServ.deleteLoginById(10);
		assertEquals(10,login.getLoginId());
	}
}
