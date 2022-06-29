package com.example.covid.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.covid.spring.entity.Admin;
import com.example.covid.spring.repository.AdminRepository;


@Service
public class AdminServiceImpl implements IAdminService {
	@Autowired
	AdminRepository adminRepo;

	@Override
	public Admin addAdmin(Admin admin) {

		return adminRepo.save(admin);
	}

	public Admin updateAdminById(int adminId, Admin admin) 
	{
		Optional<Admin> ad = adminRepo.findById(adminId);
		if (ad.isPresent()) {
			Admin dbAdmin = ad.get();
			dbAdmin.setAdminName(admin.getAdminName());
			dbAdmin.setAdminContactNo(admin.getAdminContactNo());
			return adminRepo.save(dbAdmin);
		} else {
			return null;
		}

	
	}

	public Admin deleteAdmin(int adminId)

	{
	 Optional<Admin> ad=adminRepo.findById(adminId);
	/*	if(ad.isPresent()) {
			System.out.println("service"+ad.get());
			//adminRepo.deleteById(adminId);
			adminRepo.deleteById(adminId));
			return ad.get();
		}else 
		{
			return null;
		}*/
		adminRepo.deleteById(adminId);
		return ad.get();
	}

	public Admin updateAdminName(int adminId, String newName) {
		
		Optional<Admin>admin=adminRepo.findById(adminId);
		if(admin.isPresent())
		{
			Admin dbAdmin=admin.get();
			dbAdmin.setAdminName(newName);
			return adminRepo.save(dbAdmin);
			
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<Admin> getAllAdmin() {
		
	  return adminRepo.findAll();
		
	}

	
}
