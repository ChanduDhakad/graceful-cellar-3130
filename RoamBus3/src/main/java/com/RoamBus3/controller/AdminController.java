package com.RoamBus3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.RoamBus3.exception.AdminException;
import com.RoamBus3.exception.LoginException;
import com.RoamBus3.model.Admin;
import com.RoamBus3.service.AdminService;

import jakarta.validation.Valid;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService aService;
	
	@PostMapping("/admin")
	public ResponseEntity<Admin> registerUser(@Valid @RequestBody Admin user) throws AdminException{
		Admin a=aService.registerUser(user);
		
		return new ResponseEntity<Admin>(a,HttpStatus.CREATED);
	}
	

	@GetMapping("/admin/{u}")
	public ResponseEntity<Admin> getUserDetailsHandler(@PathVariable ("u") String username) throws AdminException {

		Admin a = aService.saveUser(username);

		return new ResponseEntity<Admin>(a,HttpStatus.OK);
		
	}

	
	
	@PutMapping("/admin")
	public ResponseEntity<Admin> updateUserHandler(@Valid @RequestParam (required = false) String key, @RequestBody Admin user) throws AdminException, LoginException {

		Admin updatedUser = aService.updateUser(user, key);

		return new ResponseEntity<Admin>(updatedUser, HttpStatus.OK);

	}
	
	@DeleteMapping("/admin/{username}")
	public ResponseEntity<Admin> DeleteAdminHandler(@PathVariable ("username") String username, @RequestParam (required = false) String key) throws AdminException{
		Admin c=aService.deleteUser(username, key);
		return new ResponseEntity<Admin>(c,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/adminFind/{id}")
	public ResponseEntity<Admin> getAdminByIdHandler(@PathVariable ("id") int id) throws AdminException{
		Admin a=aService.findByAdminId(id);
		
		return new ResponseEntity<Admin>(a,HttpStatus.OK);
	}
	
	@GetMapping("/adminFindByUn/{un}")
	public ResponseEntity<Admin> GetAdminByAddressHandler(@PathVariable ("un") String username, @RequestParam (required = false) String key) throws AdminException, LoginException{
		Admin a=aService.findByUserName(username, key);
		
		return new ResponseEntity<Admin>(a,HttpStatus.OK);
	}
	
	@GetMapping("/adminlist")
	public ResponseEntity<List<Admin>> GetCustomersByAddressHandler(@RequestParam (required = false) String key) throws AdminException, LoginException{
		
		List<Admin> as=aService.findAllUsers(key);
		
		return new ResponseEntity<List<Admin>>(as,HttpStatus.OK);
	}

}
