package com.RoamBus3.service;

import com.RoamBus3.exception.AdminException;
import com.RoamBus3.exception.BusException;
import com.RoamBus3.exception.LoginException;
import com.RoamBus3.model.Bus;

public interface BusService {
	
	public Bus addBus(Bus bus, String key) throws BusException,AdminException, LoginException;
}
