package com.foodbox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodbox.entity.User;
import com.foodbox.repository.UserRepo;

@Service
public class UserService {

	
	@Autowired
	private UserRepo repo;
	
	public User addUser(User user) {
		return repo.save(user);
	}

	public Integer isUserPresent(User user) {
		// TODO Auto-generated method stub
		User user1 = repo.getUserByEmailAndName(user.getEmail(), user.getName());
		if(user1 != null){
			return user1.getId();
		}
		
		else {
			return null;
		}
	}
	
	public User login(User user) {
		// TODO Auto-generated method stub
		return repo.findByEmailPass(user.getEmail(), user.getPassword());
	}
}
