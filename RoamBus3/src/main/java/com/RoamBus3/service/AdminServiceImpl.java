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
			throw new LoginException("Login first");
		}
		Optional<Admin> a=adao.findById(user.getAdminId());
		
		if(a.isPresent()) {
		   return  adao.save(user);

		}
		throw new AdminException("You are not an admin");
		
	}

	@Override
	public Admin deleteUser(String adminUsername,String key) throws AdminException {
		Admin a=adao.findByAdminUsername(adminUsername);

		CurrentUser cu=cudao.findByUuid(key);
		
		if(a==null) {
			throw new AdminException("Sorry it's a wrong username");
		}
		if(cudao.findByUuid(key) !=null) {
			adao.delete(a);
			cudao.delete(cu);
			return a;
			
		}
		
		throw new AdminException("Please login first");
	}
	

	@Override
	public Admin findByAdminId(Integer adminId) throws AdminException {
		
		Optional<Admin> opt=adao.findById(adminId);
		
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new AdminException("there is no admin present with this id");
		
	}

	@Override
	public Admin findByUserName(String adminUserName , String key) throws AdminException, LoginException {
		CurrentUser cu=cudao.findByUuid(key);

		if(cu == null) {
			throw new LoginException("Login first");
		}
		Optional<Admin> a=adao.findById(adao.findByAdminUsername(adminUserName).getAdminId());
		
		if(a.isPresent()) {
		   return a.get();

		}
		throw new AdminException("You are not an admin");
	}

	@Override
	public List<Admin> findAllUsers(String key) throws AdminException, LoginException {
		
		CurrentUser cu=cudao.findByUuid(key);

		if(cu == null) {
			throw new LoginException("Login first");
		}
		Optional<Admin> a=adao.findById(cu.getUserId());
		
		if(a.isPresent()) {
			List<Admin> alist=adao.findAll();
			
			if(a.isEmpty()) {
				throw new AdminException("No one present in the list yet");
			}
			return alist;

		}
		throw new AdminException("You are not an admin");
		
			
		
	}

	


	

	

}
