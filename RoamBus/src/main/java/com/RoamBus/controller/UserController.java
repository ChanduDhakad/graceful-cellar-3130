package com.RoamBus.controller;

import java.net.http.HttpRequest;
import java.util.List;

import javax.validation.Valid;

import org.apache.catalina.connector.Response;
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
import org.springframework.web.servlet.function.EntityResponse;

import com.RoamBus.access.exception.AdminException;
import com.RoamBus.access.exception.LoginException;
import com.RoamBus.exception.UserException;
import com.RoamBus.model.User;
import com.RoamBus.services.UserService;




@RestController
public class UserController {

	      @Autowired
        private UserService uService;
	      
	      
	      @PostMapping("/users")
	      public ResponseEntity<User> addUser(@Valid @RequestBody User user,@RequestParam String key) throws UserException, LoginException{
	    	  
	    	  
	    	      User u=  uService.addUser(user, key);
	    	      
	    	      return new ResponseEntity<User>(u,HttpStatus.CREATED);
	    	  
	      }
	
	      
	      
	      @PutMapping("/users")
	      public ResponseEntity<User> updateUser(@Valid @RequestBody User user,@RequestParam String key) throws UserException, LoginException{
	    	  
	    	  
	    	      User u=  uService.updateUser(user, key);
	    	      
	    	      return new ResponseEntity<User>(u,HttpStatus.OK);
	    	  
	      }
	      @DeleteMapping("/users")
	      public ResponseEntity<User> deleteUser(@Valid @RequestBody User user,@RequestParam String key) throws UserException, LoginException{
	    	  
	    	  
	    	      User u=  uService.deleteUser(user, key);
	    	      
	    	      return new ResponseEntity<User>(u,HttpStatus.OK);
	    	  
	      }
	      
	      
	      @GetMapping("/users/{id}")
	      public ResponseEntity<User> viewUser(@Valid @RequestBody  @PathVariable("id") int userId,@RequestParam String key) throws UserException, LoginException{
	    	  
	    	  
	    	      User u=  uService.ViewUser(userId, key);
	    	      
	    	      return new ResponseEntity<User>(u,HttpStatus.OK);
	    	  
	      }
	      
	      
	      @GetMapping("/users")
	      public ResponseEntity< List<User>> viewUser(@Valid @RequestBody  @RequestParam String key) throws UserException, LoginException, AdminException{
	    	  
	    	  
	    	      List<User> users=  uService.ViewAllUser(key);
	    	      
	    	      return new ResponseEntity<List<User>>(users,HttpStatus.FOUND);
	    	  
	      }
}

	      
	      

