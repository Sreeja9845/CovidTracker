package com.example.covid.spring.service;

import com.example.covid.spring.entity.Address;
import com.example.covid.spring.exception.AddressNotFoundException;

public interface IAddressService {

	Address getAddressById(int addressId);

	Address addAddress( Address addr);

	Address updateAddressById(int addrId, Address addr) throws AddressNotFoundException;

	Address deleteAddress(int addrId);

	

}
