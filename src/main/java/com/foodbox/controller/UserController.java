package com.foodbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodbox.entity.User;
import com.foodbox.service.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("http://localhost:4200/")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/register")
	public ResponseEntity<Object> register(@RequestBody User user){
		User createdUser = service.addUser(user);
		if(createdUser != null) {
			return new ResponseEntity<Object> (createdUser, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<Object> ("Error while adding Item", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	} 
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody User user){
		//calling method login to save object of Customer and taking response in variable named 'created'
		User created= service.login(user);
		if(created!=null)
			return new ResponseEntity<Object>(created,HttpStatus.OK);
		else
			return new ResponseEntity<Object>("Not Found",
					HttpStatus.NOT_FOUND);
	}
}
