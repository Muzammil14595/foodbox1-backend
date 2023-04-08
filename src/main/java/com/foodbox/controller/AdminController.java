package com.foodbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodbox.entity.Admin;
import com.foodbox.service.AdminService;



@RestController
@RequestMapping("/api/admin")
@CrossOrigin("http://localhost:4200/")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody Admin admin){
		//calling method login to save object of Customer and taking response in variable named 'created'
		Admin created= adminService.adminLogin(admin);
		if(created!=null)
			return new ResponseEntity<Object>(created,HttpStatus.OK);
		else
			return new ResponseEntity<Object>("Not Found",
					HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("")
	public void changePassword(@RequestBody Admin admin) {
		adminService.changePassword(admin);
	}
}
