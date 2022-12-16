package com.RoamBus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RoamBus.model.Admin;

@Repository
public interface AdminDao extends JpaRepository<Admin, Integer> {
	
	
	public Admin findByAdminUsername(String username);
	
	
}
