package com.example.covid.spring.controller;

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

import com.example.covid.spring.entity.Login;
import com.example.covid.spring.exception.LoginNotFoundException;
import com.example.covid.spring.service.ILoginService;

@RestController
public class LoginController {
	@Autowired
ILoginService loginServ;

@GetMapping("/login/{id}")
ResponseEntity<Login>getLoginId(@PathVariable("id") int loginId)
{
	Login login=loginServ.getLoginById(loginId);
	return new ResponseEntity<>(login,HttpStatus.OK );
}
//add  
@PostMapping("/login")
ResponseEntity<Login>addLogin( @RequestBody Login login)
  {
	 Login newLogin=loginServ.addlogin(login);
	 return new ResponseEntity<>(newLogin,HttpStatus.CREATED);
  }
@PutMapping("/login/{id}")
ResponseEntity<Login> updateLoginById(@RequestBody Login login,@PathVariable("id") int loginId) throws LoginNotFoundException
{
	Login updatedLogin=loginServ.updateLoginById(login,loginId);
	return new ResponseEntity<>(updatedLogin, HttpStatus.OK);
}

@DeleteMapping("/Login/{id}")
ResponseEntity<Login >deleteLoginById(@PathVariable ("id") int loginId)
{
	Login login=loginServ.deleteLoginById(loginId);
	return new ResponseEntity<>( login, HttpStatus.OK);
}
}
