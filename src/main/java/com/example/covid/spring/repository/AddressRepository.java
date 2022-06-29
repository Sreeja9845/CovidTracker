package com.example.covid.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.covid.spring.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
