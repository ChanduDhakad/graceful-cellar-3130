package com.RoamBus.services;

import java.util.List;

import com.RoamBus.access.exception.AdminException;
import com.RoamBus.access.exception.LoginException;
import com.RoamBus.exception.BusException;

import com.RoamBus.model.Bus;



public interface BusService {

	public Bus addBus(Bus bus, String key)throws BusException, AdminException,LoginException;
	
	public Bus updateBus( Bus bus, String key) throws BusException, LoginException,AdminException;
	
	public Bus deleteBus(  Integer busId,String key) throws BusException, LoginException, AdminException;
	
	public Bus viewBus(int busId, String key) throws BusException ,LoginException;
	
	public List<Bus> viewBusByType(String busType,String key) throws BusException,LoginException;
	
	public List<Bus> viewAllBus(String key) throws BusException,LoginException;
	
}
