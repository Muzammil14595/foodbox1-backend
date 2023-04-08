package com.foodbox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodbox.entity.Admin;
import com.foodbox.repository.AdminRepo;



@Service
public class AdminService {
	@Autowired
	AdminRepo adminRepo;
	
	public Admin adminLogin(Admin admin) {
		return adminRepo.adminLogin(admin.getEmail(), admin.getPassword());
	}
	
	
	public void changePassword(Admin admin) {
		Admin oldadmin = adminRepo.getByEmail(admin.getEmail());
		if(oldadmin!= null) {
			oldadmin.setPassword(admin.getPassword());
			adminRepo.save(oldadmin);
		}
	}
}
