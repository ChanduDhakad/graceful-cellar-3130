package com.RoamBus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RoamBus.access.exception.AdminException;
import com.RoamBus.access.exception.LoginException;
import com.RoamBus.exception.UserException;
import com.RoamBus.model.Admin;
import com.RoamBus.model.CurrentUser;
import com.RoamBus.model.User;
import com.RoamBus.repository.AdminDao;
import com.RoamBus.repository.CurrentUserDao;
import com.RoamBus.repository.ReservationDao;
import com.RoamBus.repository.UserDao;

@Service
public class UserServiceImpl  implements UserService{

	             @Autowired
	         private UserDao uDao; 
	             @Autowired
	           private  CurrentUserDao cuu;
	             
	             @Autowired
	        private AdminDao adminDao;   
	             @Autowired
	             private ReservationDao rDao;
	
	             
	             
	@Override
	public User addUser(User user) throws UserException {
		            
		
		   return  uDao.save(user);
		
		      
	}



	@Override
	public User updateUser(User user, String key) throws UserException, LoginException {
		
		
		  CurrentUser cu= cuu.findByUuid(key);
          if(cu==null) throw new LoginException("Login first");
          
             Optional<User> opt=uDao.findById(user.getUserLoginId());
                 
             if(opt.isEmpty()) throw new UserException("User does not exist with UserId "+user.getUserLoginId());
                             
             
                    
             
          
             return  uDao.save(user);
		
		
	}



	@Override
	public User deleteUser(User user, String key) throws UserException, LoginException {
	
		
		
		CurrentUser cu= cuu.findByUuid(key);
        if(cu==null) throw new LoginException("Login first");
        
           Optional<User> opt=uDao.findById(user.getUserLoginId());
               
           if(opt.isEmpty()) throw new UserException("User does not exist with UserId "+user.getUserLoginId());
           
                     
        
            uDao.deleteById(user.getUserLoginId());
            return  opt.get();
            
	}



	@Override
	public User ViewUser(int Userid, String key) throws UserException, LoginException {
		
		CurrentUser cu= cuu.findByUuid(key);
        if(cu==null) throw new LoginException("Login first");
        
           Optional<User> opt=uDao.findById(Userid);
               
           if(opt.isEmpty()) throw new UserException("User does not exist with UserId "+Userid);
           
                     
        
//            uDao.deleteById(user.getUserLoginId());
            return  opt.get();
		
	}



	@Override
	public List<User> ViewAllUser(String key) throws UserException, LoginException, AdminException {
	
	
		CurrentUser cu= cuu.findByUuid(key);
        if(cu==null) throw new LoginException("Login first");
        
        
                  Optional<Admin> admin=  adminDao.findById(cu.getUserId());
         
                   if(admin.isPresent()) {
                	   List<User> users=uDao.findAll();
                	   if(users.size()==0) throw new UserException("No User found ");
                	   
                	   return users;
                	   
                   }
                   
                   throw new AdminException(" Only Access the View  Users list by Admin  ");
                  
 
	
	}



	
}
