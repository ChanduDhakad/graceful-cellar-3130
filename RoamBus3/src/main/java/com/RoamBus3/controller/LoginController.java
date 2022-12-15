package com.RoamBus3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.RoamBus3.exception.LoginException;
import com.RoamBus3.model.LoginDTO;
import com.RoamBus3.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	private LoginService lService;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginDTO dto) throws LoginException{
		String result=lService.login(dto);
		
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	@PostMapping("/logout")
	public String logout(@RequestParam (required = false) String key) throws LoginException {
		return lService.logout(key);
	}
	
}
