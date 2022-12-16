package com.RoamBus.services;

import java.util.List;

import com.RoamBus.access.exception.LoginException;
import com.RoamBus.exception.AdminException;
import com.RoamBus.model.Admin;



public interface AdminService {
	public Admin registerUser(Admin user) throws AdminException;
	
	public Admin saveUser(String username) throws AdminException;

	public Admin updateUser(Admin user, String key) throws AdminException, LoginException;

	public Admin deleteUser(String adminUsername) throws AdminException;

	public Admin findByAdminId(Integer adminId) throws AdminException;

	public Admin findByUserName(String adminUserName) throws AdminException;

	public List<Admin> findAllUsers() throws AdminException;
}
