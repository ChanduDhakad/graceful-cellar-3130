package com.RoamBus.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RoamBus.access.exception.AdminException;
import com.RoamBus.access.exception.LoginException;
import com.RoamBus.access.exception.UserException;
import com.RoamBus.exception.BusException;
import com.RoamBus.exception.ReservationException;
import com.RoamBus.model.Admin;
import com.RoamBus.model.Bus;
import com.RoamBus.model.CurrentUser;
import com.RoamBus.model.LoginDTO;
import com.RoamBus.model.LoginUserSession;
import com.RoamBus.model.Reservation;
import com.RoamBus.model.User;
import com.RoamBus.repository.AdminDao;
import com.RoamBus.repository.BusDao;
import com.RoamBus.repository.CurrentUserDao;

import com.RoamBus.repository.ReservationDao;
import com.RoamBus.repository.UserDao;

import net.bytebuddy.utility.RandomString;



@Service
public class ReservationServiceImpl implements ReservationService {

	                   @Autowired
	                private ReservationDao resDao;
	                   
	                   @Autowired
	                private BusDao busDao;
	                   
//	                   @Autowired
//		                private  SessionDao  cDao;
	
	                   
	                   @Autowired
		                private UserDao  userDao;
	                   
	              
	                   
	                   @Autowired
	               	private CurrentUserDao cudao;
	                   
	                   @Autowired
		               	private AdminDao adminDao;
//	                  
	
	@Override
	public Reservation addReservation( Reservation res,  String key,String Bname)
			     throws ReservationException, BusException, LoginException ,UserException{
		
		        // step(1)==>login check condition using given key value
		
		           CurrentUser cu=cudao.findByUuid(key);
		      if(cu==null) throw new  LoginException("Please Login first acccount ");
		                  
		            Bus bus=    busDao.findBybusName(Bname);
		            
	             //step(2)-->  check bus is available or not for given name 
		       
		       if(bus==null) throw new BusException(" Not any Bus  is aviable for   Bus Name  "+Bname +" BusId "+bus.getBusId());
		       
;		       
		       // step(3) -> Check sit available or not 
                     
               if(bus.getAvilableSeats()<=0) throw new  BusException(" Not Sit  is aviable for   Bus Name  "+Bname+Bname +" BusId "+bus.getBusId());
               
               
               //  step(4)-->find the user details using key value 
               
                 Optional<User> opt= userDao.findById(cu.getUserId());
                 
                 // step(5) check it available or not for login user id
                 
                 
                 if(opt.isEmpty()) throw new  BusException(" No user available with User Id  "+cu.getUserId());
               
               // step(4) -->  Reservation object Add   bus details and user details
               
                   res.setBus(bus);
                   res.setUser(opt.get());
                  
                  

                // step(4) --> return  And persist the Reservation object with bus details and user details to the user and 
                  res.setTime(LocalTime.now());
                  res.setLocalDate(LocalDate.now());
               Reservation resturnRes = resDao.save(res); 
        
		       return resturnRes;
		   
	}


	@Override
	public Reservation updateReservation(Reservation res,  String key,String Bname) throws LoginException,BusException,UserException,ReservationException{
		// step(1)==>login check condition using given key value
		
        CurrentUser cu=cudao.findByUuid(key);
   if(cu==null) throw new  LoginException("Please Login first acccount ");
               



                        resDao.findById(res.getReservationId()).orElseThrow( ()->new ReservationException("Not Reservation with given id "+res.getReservationId()) );
                        
                    res.setTime(LocalTime.now());
                    res.setLocalDate(LocalDate.now());
                    
                    
                    Bus bus=    busDao.findBybusName(Bname);
                    res.setBus(bus);
                    
                    Optional<User> opt= userDao.findById(cu.getUserId());
                    if(opt.isEmpty()) throw new UserException("No user is exist with Id "+cu.getUserId());
                    res.setUser(opt.get());
                    
                
                   return  resDao.save(res);
				            
				

	}
		
		
		
   	

	@Override
	public Reservation deleteReservation(int reservationId,String key) throws ReservationException,  LoginException{
		
		                 
		                 
		 
	        // step(1)==>login check condition using given key value
	
	           CurrentUser cu=cudao.findByUuid(key);
	       if(cu==null) throw new  LoginException("Please Login first acccount ");
	       
	       
	       
	       // step(2)--> find Reservation by given id
	       
	       
	         Optional<Reservation> opt= resDao.findById(reservationId);
	         if(opt.isEmpty())  new  ReservationException(" No Reservation   is aviable for Given Reservation  "+reservationId);
	       
	             
	       // step(3)--> Increase bus seat for deleted Reservation
	         
	                Reservation res= opt.get();
	       
	                 Bus bus= res.getBus();
	       
	                   bus.setAvilableSeats(bus.getAvilableSeats()+1);
	                   
	                   busDao.save(bus);
	                   return res;
	       
	     
		
	}

	
	

	@Override
	public Reservation viewReservation(int reservationId,String key)
			throws ReservationException, BusException, LoginException, UserException {
	
		
		
		
		
		 // step(1)==>login check condition using given key value
		
        CurrentUser cu=cudao.findByUuid(key);
    if(cu==null) throw new  LoginException("Please Login first acccount ");
    
    
    
    // step(2)--> find Reservation by given id
    
    
      Optional<Reservation> opt= resDao.findById(reservationId);
      if(opt.isEmpty())  new  ReservationException(" No Reservation   is aviable for Given Reservation  "+reservationId);
    
      
    if(opt.get()==null)new  ReservationException(" No Reservation   is aviable for Given Reservation  "+reservationId);
                
                
                return opt.get();
	
	}


	@Override
	public List<Reservation> viewAllReservation(String key) throws ReservationException, LoginException, AdminException {
		
		
		// step(1)--> check  user is Login or not and after check user is  admin or not 
		  CurrentUser cuu=  cudao.findByUuid(key);
		  if(cuu==null) throw new  LoginException("Please Login first acccount ");
		  
		                     Optional<Admin> admin= adminDao.findById(cuu.getUserId());   
		
		
		 
		 if(admin.isEmpty())  throw new AdminException("No Admin Registor with  AdminId  "+cuu.getUserId());
		
		 
   // step2 check list of reservation is empty or not 
     

     List<Reservation>listOfReservation=resDao.findAll();

   if(listOfReservation.isEmpty()) throw new  ReservationException(" There is Not any Reseveration Exit  ");


    return listOfReservation; 
	}



}
