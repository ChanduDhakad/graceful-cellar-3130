package com.RoamBus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RoamBus.access.exception.AdminException;
import com.RoamBus.access.exception.LoginException;
import com.RoamBus.exception.RouteException;
import com.RoamBus.model.Admin;
import com.RoamBus.model.Bus;
import com.RoamBus.model.CurrentUser;
import com.RoamBus.model.Route;
import com.RoamBus.repository.AdminDao;
import com.RoamBus.repository.BusDao;
import com.RoamBus.repository.CurrentUserDao;
import com.RoamBus.repository.RouteDao;




@Service
public class RouteServiceImpl implements RouteService {

	@Autowired
	private CurrentUserDao cudao;
	
	@Autowired
	private AdminDao adao;
	
	@Autowired
	private RouteDao rdao;
	
	@Autowired
	private BusDao bdao;
	
	@Override
	public Route addRoute(Route route, String key) throws AdminException, RouteException, LoginException {
        
		CurrentUser cu=cudao.findByUuid(key);
		
		if(cu == null) {
			throw new LoginException("Please login first");
		}
		
		Optional<Admin> a=adao.findById(cu.getUserId());
		
		if(a.isPresent()) {
		    List<Bus> blist=(bdao.findByRouteFromAndRouteTo(route.getRouteFrom(), route.getRouteTo()));
			
			if(blist.size() !=0) {
				 route.setBus(bdao.findByRouteFromAndRouteTo(route.getRouteFrom(), route.getRouteTo()));	
					return rdao.save(route);
			}
			throw new RouteException("No bus is present in this route");
		 
		}
		throw new AdminException("You are not an admin");
		
	}

	@Override
	public Route updateRoute(Route route, String key) throws AdminException, RouteException, LoginException {
        
		CurrentUser cu=cudao.findByUuid(key);
		
		if(cu == null) {
			throw new LoginException("Login first");
		}
		Optional<Admin> a=adao.findById(cu.getUserId());
		
		if(a.isPresent()) {
			
			Optional<Route> r=rdao.findById(route.getRouteId());
			
			if(r.isPresent()) {
				
			List<Bus> blist=bdao.findByRouteFromAndRouteTo(route.getRouteFrom(), route.getRouteTo());
				
			if(blist.size() != 0) {
				 route.setBus(blist);	
						return rdao.save(route);
			}
				throw new RouteException("No bus is present in this route");

			}
		  throw new RouteException("wrong route Id!");

		}
		throw new AdminException("You are not an admin");
	}

	@Override
	public Route deleteRoute(int routeId, String key) throws AdminException, RouteException,LoginException {
          CurrentUser cu=cudao.findByUuid(key);
		
		if(cu == null) {
			throw new LoginException("Login first");
		}
		Optional<Admin> a=adao.findById(cu.getUserId());
		
		if(a.isPresent()) {
			Optional<Route> r=rdao.findById(routeId);
			
			if(r.isPresent()) {
				 rdao.delete(r.get());
				 return r.get();
			}
			throw new RouteException("Wrong route id");
		}
		throw new AdminException("Not an admin");
		
	}

	@Override
	public Route viewRoute(int routeId, String key) throws LoginException, RouteException, AdminException {
		 CurrentUser cu=cudao.findByUuid(key);
			
			if(cu == null) {
				throw new LoginException("Login first");
			}
			Optional<Admin> a=adao.findById(cu.getUserId());
			
			if(a.isPresent()) {
				Optional<Route> r=rdao.findById(routeId);
				
				if(r.isPresent()) {
					 return r.get();
				}
				throw new RouteException("Wrong route id");
			}
			throw new AdminException("Not an admin");
			
	}

	@Override
	public List<Route> viewAllRoute(String key) throws LoginException, RouteException, AdminException {
		 CurrentUser cu=cudao.findByUuid(key);
			
			if(cu == null) {
				throw new LoginException("Login first");
			}
			Optional<Admin> a=adao.findById(cu.getUserId());
			
			if(a.isPresent()) {
				List<Route> r=rdao.findAll();
				
				if(r.size() != 0) {
					 return r;
				}
				throw new RouteException("Wrong route id");
			}
			throw new AdminException("Not an admin");
	}

	

}
