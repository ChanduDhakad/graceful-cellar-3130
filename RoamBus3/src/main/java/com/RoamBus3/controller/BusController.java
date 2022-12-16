package com.RoamBus3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.RoamBus3.exception.AdminException;
import com.RoamBus3.exception.BusException;
import com.RoamBus3.exception.LoginException;
import com.RoamBus3.model.Bus;
import com.RoamBus3.service.BusService;

import jakarta.validation.Valid;

@RestController
public class BusController {

	@Autowired
	private BusService bService;
	
	@PostMapping("/bus")
	public ResponseEntity <Bus> registerUser(@Valid @RequestBody Bus bus, @RequestParam ("key") String key) throws BusException, AdminException,LoginException{
		Bus b=bService.addBus(bus, key);
		
		return new ResponseEntity<Bus>(b,HttpStatus.CREATED);
	}
	
}
