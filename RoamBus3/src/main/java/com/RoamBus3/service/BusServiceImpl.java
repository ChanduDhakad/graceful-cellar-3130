package com.RoamBus3.service;

import java.time.LocalTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RoamBus3.exception.AdminException;
import com.RoamBus3.exception.BusException;
import com.RoamBus3.exception.LoginException;
import com.RoamBus3.model.Admin;
import com.RoamBus3.model.Bus;
import com.RoamBus3.model.CurrentUser;
import com.RoamBus3.model.Route;
import com.RoamBus3.repository.AdminDao;
import com.RoamBus3.repository.BusDao;
import com.RoamBus3.repository.CurrentUserDao;

@Service
public class BusServiceImpl implements BusService {

	@Autowired
	private BusDao bdao;
	
	@Autowired
	private CurrentUserDao cudao;
	
	@Autowired
	private AdminDao adao;
	
	
	@Override
	public Bus addBus(Bus bus, String key)throws BusException, AdminException,LoginException {
		
         CurrentUser cu=cudao.findByUuid(key);
         
		if(cu == null) {
			throw new LoginException("Login first");
		}
		Optional<Admin> a=adao.findById(cu.getUserId());
		
		if(a.isPresent()) {
			
			Route r=new Route();
			bus.setDepurtureTime(LocalTime.now());
			bus.setArrivalTime(bus.getDepurtureTime().plusHours(15));
		   return  bdao.save(bus);

		}
		throw new AdminException("You are not an admin");
		
	}

}
