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

import com.example.covid.spring.entity.Address;
import com.example.covid.spring.exception.AddressNotFoundException;
import com.example.covid.spring.service.IAddressService;


@RestController
public class AddressController
{
	@Autowired
	IAddressService addressServ;
	
	@GetMapping("/address/{id}")
	ResponseEntity<Address>getAddId(@PathVariable("id") int addressId)
	{
		Address addr=addressServ.getAddressById(addressId);
		return new ResponseEntity<>(addr,HttpStatus.OK );
	}
	//add  addresss
	@PostMapping("/address")
    ResponseEntity<Address>addAddress(@Valid @RequestBody Address addr)
      {
    	 Address newAddr=addressServ.addAddress(addr);
    	 return new ResponseEntity<>(newAddr,HttpStatus.CREATED);
      }
	//update
	@PutMapping("/address/{id}")
	ResponseEntity<Address> updateAddressById(@RequestBody Address addr ,@PathVariable("id") int addrId) throws AddressNotFoundException
	{
		Address updatedAddr=addressServ.updateAddressById(addrId,addr);
		return new ResponseEntity<>(updatedAddr, HttpStatus.OK);
	}
	//delete
	@DeleteMapping("/address/{id}")
	ResponseEntity<Address >deleteAddress(@PathVariable ("id") int addrId)
	{
		Address addr=addressServ.deleteAddress(addrId);
		return new ResponseEntity<>(addr, HttpStatus.OK);
	}
}
