package com.RoamBus.services;



import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RoamBus.access.exception.AdminException;
import com.RoamBus.access.exception.LoginException;
import com.RoamBus.exception.BusException;
import com.RoamBus.model.Admin;
import com.RoamBus.model.Bus;
import com.RoamBus.model.CurrentUser;
import com.RoamBus.model.Route;
import com.RoamBus.repository.AdminDao;
import com.RoamBus.repository.BusDao;
import com.RoamBus.repository.CurrentUserDao;


@Service
public class BusServiceImpl implements BusService {

	@Autowired
	private BusDao bdao;
	
	@Autowired
	private CurrentUserDao cudao;
	
	@Autowired
	private AdminDao adao;
	
	
	@Override
	public Bus addBus(Bus bus, String key)throws BusException,LoginException, AdminException {
		
		
		
		
		 CurrentUser cu=cudao.findByUuid(key);
         
			if(cu == null) {
				throw new LoginException("Login first");
			}
			Optional<Admin> a=adao.findById(cu.getUserId());
			
			if(a.isPresent()) {
				
//				Route r=new Route();
				bus.setDepurtureTime(LocalTime.now());
				bus.setArrivalTime(bus.getDepurtureTime().plusHours(15));
				
				System.out.println("==============="+ bus);
			   return  bdao.save(bus);
			  

			}
			throw new AdminException("You are not an admin");
		
	}


	


	@Override
	public Bus updateBus( Bus bus, String key) throws BusException, LoginException,AdminException{
		
		
		
		 CurrentUser cu=cudao.findByUuid(key);
         
			if(cu == null) {
				throw new LoginException("Login first");
			}
			Optional<Admin> a=adao.findById(cu.getUserId());
			
			if(a.isPresent()) {
				
				
			Optional<Bus> opt=	bdao.findById(bus.getBusId());  
				
			if(opt.isEmpty()) throw new BusException("No Bus is found with BusId "+bus.getBusId());
				
			  Route r=new Route();
				bus.setDepurtureTime(LocalTime.now());
				bus.setArrivalTime(bus.getDepurtureTime().plusHours(15));
			   return  bdao.save(bus);
			  

			}
			throw new AdminException("You are not an admin");
		
		
		
	}


	@Override
	public Bus deleteBus(  Integer busId,String key) throws BusException, LoginException, AdminException {
		
		
		

		 CurrentUser cu=cudao.findByUuid(key);
        
			if(cu == null) {
				throw new LoginException("Login first");
			}
			Optional<Admin> a=adao.findById(cu.getUserId());
			
			if(a.isPresent()) {
				
				
			Optional<Bus> opt=	bdao.findById(busId);  
				
			if(opt.isEmpty()) throw new BusException("No Bus is found with BusId "+busId);
				
			       
			    bdao.delete(opt.get());
			   return  opt.get();
			  

			}
			throw new AdminException("You are not an admin");
		
	}


	@Override
	public Bus viewBus(int busId, String key) throws BusException ,LoginException{
	
		
		
		
		
		
		 CurrentUser cu=cudao.findByUuid(key);
	        
			if(cu == null) {
				throw new LoginException("Login first");
			}

				
				
			Optional<Bus> opt=	bdao.findById(busId);  
				
			if(opt.isEmpty()) throw new BusException("No Bus is found with BusId "+busId);
				
			       
			   
			   return  opt.get();

		
	}


	@Override
	public List<Bus> viewBusByType(String busType,String key) throws BusException,LoginException {
	
		
		
		

		 CurrentUser cu=cudao.findByUuid(key);
	        
			if(cu == null) {
				throw new LoginException("Login first");
			}

				
				
			          List<Bus> buses=	bdao.findByBusType(busType);
			          
			      	if(buses.size()==0) throw new BusException("No Bus is found with BusType "+busType);
			          
			          
			          return buses;
				
		
		
	}


	@Override
	public List<Bus> viewAllBus(String key) throws BusException,LoginException {
	
		
		


		 CurrentUser cu=cudao.findByUuid(key);
	        
			if(cu == null) {
				throw new LoginException("Login first");
			}

				
				
			          List<Bus> buses=	bdao.findAll();
			          
			      	if(buses.size()==0) throw new BusException("No Bus Found ");
			          
			          
			          return buses;
	
		
		
		
	}

}
