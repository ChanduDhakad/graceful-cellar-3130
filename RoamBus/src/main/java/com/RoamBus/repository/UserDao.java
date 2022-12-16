package com.RoamBus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RoamBus.model.*;


@Repository
public interface UserDao  extends JpaRepository<User, Integer>{
	
	
	
}
