package com.RoamBus.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.RoamBus.access.exception.AdminException;
import com.RoamBus.access.exception.LoginException;
import com.RoamBus.exception.BusException;
import com.RoamBus.model.Bus;
import com.RoamBus.services.BusService;



@RestController
public class BusController {

	@Autowired
	private BusService bService;
	
	
	
	@PostMapping("/bus")
	public ResponseEntity <Bus> registerBus(@Valid @RequestBody Bus bus, @RequestParam ("key") String key) throws BusException, AdminException, LoginException{
		
		
		Bus b=bService.addBus(bus, key);
		
		return new ResponseEntity<Bus>(b,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/bus")
	public ResponseEntity <Bus> updateBus(@Valid @RequestBody Bus bus, @RequestParam ("key") String key) throws BusException, AdminException, LoginException{
		
		
		Bus b=bService.updateBus(bus, key);
		
		return new ResponseEntity<Bus>(b,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/bus/{id}")
	public ResponseEntity <Bus> deleteBus(  @PathVariable Integer id, @RequestParam ("key") String key) throws BusException, AdminException, LoginException{
		
		
		Bus b=bService.deleteBus(id, key);
		
		return new ResponseEntity<Bus>(b,HttpStatus.OK);
	}
	
	
	

	@GetMapping("/bus/{id}")
	public ResponseEntity <Bus> viewBus(  @PathVariable Integer id, @RequestParam ("key") String key) throws BusException, LoginException{
		
		
		Bus b=bService.viewBus(id, key);
		
		return new ResponseEntity<Bus>(b,HttpStatus.OK);
	}
	
	
	
	

	@GetMapping("/buses/{busType}")
	public ResponseEntity <List<Bus>> viewBusesByType(  @PathVariable String busType, @RequestParam ("key") String key) throws BusException, LoginException{
		
		
		List<Bus> b=bService.viewBusByType(busType, key);
		
		return new ResponseEntity<List<Bus>>(b,HttpStatus.OK);
	}
	
	
	
	
	@GetMapping("/allBuses")
	public ResponseEntity <List<Bus>> viewAllBuses(   @RequestParam ("key") String key) throws BusException, LoginException{
		
		
		List<Bus> b=bService.viewAllBus(key);
		
		return new ResponseEntity<List<Bus>>(b,HttpStatus.OK);
	}
	
	
}
