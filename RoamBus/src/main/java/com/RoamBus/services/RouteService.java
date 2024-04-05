package com.RoamBus.services;

import java.util.List;
import com.RoamBus.access.exception.AdminException;
import com.RoamBus.access.exception.LoginException;
import com.RoamBus.exception.RouteException;
import com.RoamBus.model.Route;

public interface RouteService{	
	public Route addRoute(Route route, String key) throws AdminException, RouteException, LoginException;
	public Route updateRoute(Route route, String key) throws AdminException, RouteException, LoginException;	
	public Route deleteRoute(int routeId, String key) throws AdminException, RouteException,LoginException;	
	public Route viewRoute(int routeId, String key) throws LoginException, RouteException, AdminException;	
	public List<Route> viewAllRoute(String key) throws LoginException,RouteException,AdminException;
	
	
}
