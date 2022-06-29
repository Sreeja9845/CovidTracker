package com.example.covid.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.covid.spring.entity.Address;
import com.example.covid.spring.exception.AddressNotFoundException;
import com.example.covid.spring.repository.AddressRepository;

@Service
public class AddressServiceImpl implements IAddressService {
	@Autowired
	AddressRepository addrRepo;
	
	public Address getAddressById(int addrId)
	{
		Optional <Address> addr=addrRepo.findById(addrId);
		if(addr.isPresent()) {
			return addr.get();
		}
		else {
			return null;
		}
		
	}


	@Override
	public Address addAddress(Address addr)
	{
		
		return addrRepo.save(addr);
	}


	@Override
	public Address updateAddressById(int addrId ,Address addr) throws AddressNotFoundException
	{
		
		//Employee emp= empRepo.getById(empId);
		Optional<Address> dbaddr=addrRepo.findById(addrId);
		if(dbaddr.isPresent())
		{
			return addrRepo.save(addr);
		}
		else 
		{
			throw new AddressNotFoundException("Employee not found");
		}
	}


	@Override
	public Address deleteAddress(int addrId) 
	{
		 Optional <Address> addr=addrRepo.findById(addrId);
		if(addr.isPresent()) {
			addrRepo.deleteById(addrId);
		}else 
		{
			return null;
		}
		return addr.get();
	}


	
}
