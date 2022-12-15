package com.RoamBus3.service;

import com.RoamBus3.exception.LoginException;
import com.RoamBus3.model.LoginDTO;

public interface LoginService {
	
	public String login(LoginDTO dto) throws LoginException;
	
	public String logout(String key)throws LoginException;
}
