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
import com.RoamBus.exception.RouteException;
import com.RoamBus.model.Route;
import com.RoamBus.services.RouteService;

@RestController
public class RouteController {

	@Autowired
	private RouteService rService;

	@PostMapping("/route")
	public ResponseEntity<Route> registerRoute(@Valid @RequestBody Route route, @RequestParam("key") String key)
			throws AdminException, RouteException, LoginException {
		Route r = rService.addRoute(route, key);
		return new ResponseEntity<Route>(r, HttpStatus.CREATED);
	}

	@PutMapping("/route")
	public ResponseEntity<Route> updateUserHandler(@Valid @RequestParam(required = false) String key,
			@RequestBody Route route) throws AdminException, LoginException, RouteException {
		Route updatedRoute = rService.updateRoute(route, key);
		return new ResponseEntity<Route>(updatedRoute, HttpStatus.OK);
	}

	@DeleteMapping("/route/{id}")
	public ResponseEntity<Route> DeleteCustomerHandler(@PathVariable("id") int id, @RequestParam("key") String key)
			throws AdminException, RouteException, LoginException {
		Route r = rService.deleteRoute(id, key);
		return new ResponseEntity<Route>(r, HttpStatus.OK);
	}

	@GetMapping("/route/{id}")
	public ResponseEntity<Route> getCustomerByIdHandler(@PathVariable("id") int id, @RequestParam("key") String key)
			throws LoginException, RouteException, AdminException {
		Route r = rService.viewRoute(id, key);
		return new ResponseEntity<Route>(r, HttpStatus.OK);
	}

	@GetMapping("/routes")
	public ResponseEntity<List<Route>> getAllCustomersHandler(@RequestParam("key") String key)
			throws LoginException, RouteException, AdminException {
		List<Route> rs = rService.viewAllRoute(key);
		return new ResponseEntity<List<Route>>(rs, HttpStatus.OK);
	}
}
