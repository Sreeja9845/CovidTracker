package com.example.covid.spring.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.covid.spring.entity.Admin;
import com.example.covid.spring.service.IAdminService;




@RestController
public class AdminController
{
	
	@Autowired
	IAdminService adminServ;
	
	@GetMapping("/admin") ResponseEntity<List<Admin>> getAllAdmin() 
	{
		List<Admin> listAdmin=adminServ.getAllAdmin();
		 return new
		ResponseEntity<>(listAdmin, HttpStatus.OK);
	 }
	@PostMapping("/admin")
	 ResponseEntity<Admin> addAdmin(@RequestBody Admin admin)
	 {
	 Admin newAdmin= adminServ.addAdmin(admin);
	 return new ResponseEntity<>(newAdmin,HttpStatus.CREATED); 
	 }
	
	 @PutMapping("/admin/{id}")
	 ResponseEntity<Admin>updateAdminById(@RequestBody Admin admin,@PathVariable("id") int adminId)
	 {
		 Admin updateAdmin=adminServ.updateAdminById(adminId,admin);
		 return new ResponseEntity<>(updateAdmin,HttpStatus.OK);
		 
	 }
	 @PatchMapping("/employee/{id}")
		ResponseEntity<Admin> updateAdminName(@PathVariable("id") int empId, @RequestBody String newName)
		{
			Admin updatedAdmin=adminServ.updateAdminName(empId, newName);
		       return new ResponseEntity<>(updatedAdmin,HttpStatus.OK);
		}
	 @DeleteMapping("/admin/{id}")
		ResponseEntity<Admin> deleteAdmin(@PathVariable("id") int adminId)
		{
			Admin ad=adminServ.deleteAdmin(adminId);
			System.out.println("controller"+ad.getAdminName());
			return new ResponseEntity<>(ad, HttpStatus.OK);
		}
	 
	 
}
