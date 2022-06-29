package com.example.covid.spring.service;

import java.util.List;

import com.example.covid.spring.entity.Admin;

public interface IAdminService 
{
	List<Admin> getAllAdmin();
	Admin addAdmin(Admin admin);
	Admin updateAdminById(int adminId, Admin admin);
	Admin deleteAdmin(int adminId);
	Admin updateAdminName(int empId, String string);
	
	
}
