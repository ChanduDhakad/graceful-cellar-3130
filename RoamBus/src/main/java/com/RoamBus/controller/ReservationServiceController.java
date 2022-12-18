package com.RoamBus.controller;

import java.util.Optional;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.RoamBus.access.exception.AdminException;
import com.RoamBus.access.exception.LoginException;
import com.RoamBus.access.exception.UserException;
import com.RoamBus.exception.BusException;
import com.RoamBus.exception.ReservationException;
import com.RoamBus.model.LoginUserSession;
import com.RoamBus.model.Reservation;
import com.RoamBus.repository.UserDao;
import com.RoamBus.services.ReservationService;

import antlr.collections.List;
@RestController
public class ReservationServiceController {

	                 @Autowired
	  private   ReservationService reservationService;
	                 
	                @Autowired
	               private   UserDao userDao;
	                 
	                 
	                 
	                 
	                 
	          

	                 
	                 
	                 
	                 
	                 
	                 
	                 
	                 
	                 
	                 
	                 
	   // Add new Reservation and verify login using input data email and password          
	
	@PostMapping("/addReservation")
	public ResponseEntity<Reservation> addReservation(@Valid @RequestBody   Reservation res,@RequestParam(required = false) String key ,@RequestParam(required = false) String busName) throws ReservationException, BusException, LoginException, UserException{
		
		
		System.err.println("res  "+res);
		              Reservation resServices=  reservationService.addReservation(res,key,busName);
		
		              return new ResponseEntity<Reservation>(resServices,HttpStatus.CREATED);

	}
	
	
	
	
	
	
	
	
	@PutMapping("/updateReservation")
	public ResponseEntity<Reservation> updateReservation(@Valid @RequestBody   Reservation res,@RequestParam(required = false) String key ,@RequestParam(required = false) String busName ) throws ReservationException, BusException, LoginException, UserException{
		
		              Reservation resServices=  reservationService.updateReservation(res, key,busName);
		
		              return new ResponseEntity<Reservation>(resServices,HttpStatus.ACCEPTED);

	}
	
	
	// Delete Reservation by given id verify user by user email id and password
	
	
	@DeleteMapping("/deleteReservation/{id}")
	public ResponseEntity<Reservation> addReservation(@Valid @PathVariable Integer id ,@RequestParam String key) throws ReservationException, BusException, LoginException, UserException{
	
	              Reservation resServices=  reservationService.deleteReservation(id, key);
	              return new ResponseEntity<Reservation>(resServices,HttpStatus.OK);
	
	
	
	}
	// view Reservation 
	
	@GetMapping("/Reservation/{id}")
	public ResponseEntity<Reservation> viewReservation(@Valid @PathVariable Integer id ,@RequestParam String key) throws ReservationException, BusException, LoginException, UserException{
	
	              Reservation resServices=  reservationService.viewReservation(id, key);
	              return new ResponseEntity<Reservation>(resServices,HttpStatus.OK);
	
	
	
	}
	
	
	
	
	
	
	
	       
		@GetMapping("/viewAllReservation/{key}")
		public ResponseEntity <java.util.List<Reservation>> viewAllReservation(@Valid @RequestBody  @PathVariable String key ) throws ReservationException, BusException, LoginException, UserException, AdminException{
			
			java.util.List<Reservation> resServices=  reservationService.viewAllReservation(key);
			
			              return new ResponseEntity<java.util.List<Reservation>>(resServices,HttpStatus.ACCEPTED);

		}


//	
	

//	
	
}
