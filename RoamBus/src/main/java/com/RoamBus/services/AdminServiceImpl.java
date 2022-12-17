package com.RoamBus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RoamBus.access.exception.LoginException;
import com.RoamBus.exception.AdminException;
import com.RoamBus.model.Admin;
import com.RoamBus.model.CurrentUser;
import com.RoamBus.repository.AdminDao;
import com.RoamBus.repository.CurrentUserDao;



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
//		CurrentUser cu=cudao.findByUuid(key);
//		
//		if(cu == null) {
//			throw new LoginException("Login first");
//		}
//		if(user.getAdminId()==cu.getUserId()){
//			return adao.save(user);
//		}
//		throw new AdminException("Invalid admin details");
//		
		CurrentUser cu=cudao.findByUuid(key);
		
		if(cu == null) {
			throw new LoginException("Login first");
		}
		Optional<Admin> a=adao.findById(user.getAdminId());
		
		if(a.isPresent()) {
		   return  adao.save(user);

		}
		throw new AdminException("You are not an admin");
		
		
		
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