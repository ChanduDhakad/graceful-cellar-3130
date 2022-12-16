package com.RoamBus.services;

import java.time.LocalDateTime;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RoamBus.*;
import com.RoamBus.access.exception.LoginException;
import com.RoamBus.model.CurrentUser;
import com.RoamBus.model.LoginDTO;
import com.RoamBus.repository.AdminDao;
import com.RoamBus.repository.CurrentUserDao;

import net.bytebuddy.utility.RandomString;



@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private AdminDao  adao;
	
	@Autowired
	private CurrentUserDao cudao;

	
	@Override
	public String login(LoginDTO dto) throws LoginException {
		com.RoamBus.model.Admin a=adao.findByAdminUsername(dto.getUsername());
		
		if(a == null) {
			throw new LoginException("Please enter a valid username");
		}
		
		Optional<CurrentUser> cu=cudao.findById(a.getAdminId());
//		Optional<CurrentUser> cu2=cudao.findById(u.getUserId());
		if(cu.isPresent()) {
			throw new LoginException("already loggedIn");
		}
		
		if(a.getPassword().equals(dto.getPassword())) {
			
			RandomString rs= new RandomString();
			 String key =rs.make(6);
			 
			 boolean val=true;
			 CurrentUser newCu=new CurrentUser(a.getAdminId(),key,val, LocalDateTime.now());
			 cudao.save(newCu);
			 
			 return newCu.toString();
			 
		}
		throw new LoginException("Please enter a valid password");
		
		
	}

	@Override
	public String logout(String key) throws LoginException {
		CurrentUser cu=cudao.findByUuid(key);
		
		if(cu == null) {
			throw new LoginException("User not loggedin with this username");
		}
		
		cudao.delete(cu);
		
		return "Loggedout";
	}

}
