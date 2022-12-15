package com.RoamBus.services;

import java.util.List;

import com.RoamBus.exception.BusException;
import com.RoamBus.exception.LogException;
import com.RoamBus.model.Bus;



public interface BusService {

	public Bus addBus(Integer adminId ) throws  BusException;
	
	public Bus updateBus(Integer adminId, Bus bus) throws BusException, LogException;
	
	public Bus deleteBus(Integer adminId, Integer busId) throws BusException, LogException;
	
	public Bus viewBus(Integer busId) throws BusException;
	
	public List<Bus> viewBusByType(String busType) throws BusException;
	
	public List <Bus> viewAllBus() throws BusException;
	
}
