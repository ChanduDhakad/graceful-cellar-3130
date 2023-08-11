package com.RoamBus.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.RoamBus.access.exception.*;
import com.RoamBus.exception.UserException;
import com.RoamBus.model.User;
import com.RoamBus.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService uService;

	@PostMapping("/users")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) throws UserException {
		User u = uService.addUser(user);
		return new ResponseEntity<User>(u, HttpStatus.CREATED);
	}

	@PutMapping("/users")
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user, @RequestParam String key)
			throws UserException, LoginException {
		User u = uService.updateUser(user, key);
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}

	@DeleteMapping("/users")
	public ResponseEntity<User> deleteUser(@Valid @RequestBody User user, @RequestParam String key)
			throws UserException, LoginException {
		User u = uService.deleteUser(user, key);
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> viewUser(@Valid @RequestBody @PathVariable("id") int userId, @RequestParam String key)
			throws UserException, LoginException {
		User u = uService.ViewUser(userId, key);
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> viewUser(@Valid @RequestBody @RequestParam String key)
			throws UserException, LoginException, AdminException {
		List<User> users = uService.ViewAllUser(key);
		return new ResponseEntity<List<User>>(users, HttpStatus.FOUND);
	}
}
