package com.RoamBus.services;


import com.RoamBus.access.exception.LoginException;
import com.RoamBus.model.LoginDTO;

public interface LoginService {
	
	public String login(LoginDTO dto) throws LoginException;
	
	public String logout(String key)throws LoginException;
}
