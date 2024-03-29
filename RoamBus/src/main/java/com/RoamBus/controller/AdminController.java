package com.RoamBus.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.RoamBus.access.exception.AdminException;
import com.RoamBus.access.exception.LoginException;
import com.RoamBus.model.Admin;
import com.RoamBus.services.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService aService;

	@PostMapping("/admin")
	public ResponseEntity<Admin> registerUser(@Valid @RequestBody Admin user) throws AdminException {
		Admin a = aService.registerAdmin(user);
		return new ResponseEntity<Admin>(a, HttpStatus.CREATED);
	}
	
	@PutMapping("/admin")
	public ResponseEntity<Admin> updateUserHandler(@Valid @RequestParam(required = false) String key,
			@RequestBody Admin user) throws AdminException, LoginException {
		Admin updatedUser = aService.updateAdmin(user, key);
		return new ResponseEntity<Admin>(updatedUser, HttpStatus.OK);
	}
}
