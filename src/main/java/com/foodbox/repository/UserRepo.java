package com.foodbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.foodbox.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	
	public User getUserByEmailAndName(String email,String name);
	
	@Query("from User u where u.email=:email and u.password=:password")
	public User findByEmailPass(String email, String password);
}
