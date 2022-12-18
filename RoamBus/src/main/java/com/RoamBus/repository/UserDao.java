package com.RoamBus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RoamBus.model.User;

public interface UserDao extends JpaRepository<User, Integer> {

	
	
	public User findByUserName(String username);
}
