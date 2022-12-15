package com.RoamBus3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RoamBus3.exception.AdminException;
import com.RoamBus3.exception.LoginException;
import com.RoamBus3.model.Admin;
import com.RoamBus3.model.CurrentUser;
import com.RoamBus3.repository.AdminDao;
import com.RoamBus3.repository.CurrentUserDao;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adao;
	
	@Autowired
	private CurrentUserDao cudao;
	
	
	@Override
	public Admin registerUser(Admin user) throws AdminException {
		Admin a=adao.save(user);
		
		return a;
	}
	
	@Override
	public Admin saveUser(String username) throws AdminException {
		Admin existingUser = adao.findByAdminUsername(username);
		
	
		return existingUser;
	}


	@Override
	public Admin updateUser(Admin user, String key) throws AdminException, LoginException {
		CurrentUser cu=cudao.findByUuid(key);
		
		if(cu == null) {
			throw new AdminException("Please provide valid credential");
		}
		if(user.getAdminId() == cu.getUserId()) {
			return adao.save(user);
		}
		throw new AdminException("Invalid admin details");
		
	}

	@Override
	public Admin deleteUser(String adminUsername) throws AdminException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin findByAdminId(Integer adminId) throws AdminException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin findByUserName(String adminUserName) throws AdminException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> findAllUsers() throws AdminException {
		// TODO Auto-generated method stub
		return null;
	}


	

	

}
