package com.RoamBus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RoamBus.access.exception.AdminException;
import com.RoamBus.access.exception.LoginException;
import com.RoamBus.exception.FeedbackException;
import com.RoamBus.model.Admin;
import com.RoamBus.model.CurrentUser;
import com.RoamBus.model.Feedback;
import com.RoamBus.model.User;
import com.RoamBus.repository.AdminDao;
import com.RoamBus.repository.CurrentUserDao;
import com.RoamBus.repository.FeedbackDao;
import com.RoamBus.repository.UserDao;

@Service
public class feedbackServiceImpl implements FeedbackService{
                    
	        @Autowired
	         private FeedbackDao fDao;
	        @Autowired
	        private UserDao uDao;
	        
	        @Autowired
	        private CurrentUserDao cDao;
	        
	        @Autowired
	 private AdminDao aDao;
	
	@Override
	public Feedback addFeedBack(Feedback feedback,  String Key) throws LoginException,FeedbackException {
		 
		     
		            
		        	
		        	CurrentUser cuu= cDao.findByUuid(Key);
		        	if(cuu!=null) {
		        		
		        		
		        		 return fDao.save(feedback);
		        	}
		        	
		        	throw new LoginException("Please Login first ");
		        
		        
		       
		                
		      
		
	}


	@Override
	public Feedback updateFeedBack(Feedback feedback,  String Key) throws LoginException, FeedbackException {
		
		
		
		
//		  Optional<User> opt=  uDao.findById(UserId);
	        
//	        if(opt.isPresent()) {
	        	
	        	// check login
	        	
	        	CurrentUser cuu= cDao.findByUuid(Key);
	        	if(cuu!=null) {
	        		
	        	  // feedback prsent or not
	        		
	        	        Optional<Feedback> fb= 	fDao.findById(feedback.getFeedbackId());
	        	        
	        	        System.out.println(" ======"+fb.get());
	        	        if(fb.isEmpty()) {
	        	        	
	        	        	 throw new FeedbackException("Feedback is not present with given feedback Id "+feedback.getFeedbackId());
	    	        		 
	        	        }
	        		
	        		return  fDao.save(feedback);
	        	
	        	
	        }
	        	throw new LoginException("Please Login first ");
	 
		
	}




	@Override
	public Feedback viewFeedBack(int feedbackId, String Key) throws LoginException, FeedbackException {
	

		
		
		
		CurrentUser cuu= cDao.findByUuid(Key);
    	if(cuu!=null) {
    		
    		            
    		
    		      
    		           Optional<Feedback> opt=  fDao.findById(feedbackId);
    		           
    		           
    		           if(opt.isPresent()) return opt.get();
    		           
    		           throw new FeedbackException("Feedback not found with given FeedbackId "+feedbackId);
    	}
    	
    	throw new LoginException("Please Login first ");
		
		
		
	
		
		
	}


	@Override
	public List<Feedback> viewAllFeedBack(String Key) throws LoginException, FeedbackException, AdminException {



		CurrentUser cuu= cDao.findByUuid(Key);
    	if(cuu!=null) {
    		
    		            
    		// login user is admin or not
    		               
    		
    		
                       Optional<Admin>  opt=  aDao.findById(cuu.getUserId());	
                       
                       if(opt.isPresent()) {
                    	   
                    	   
         		          List<Feedback> feedbacks=  fDao.findAll();
         		           
         		           
         		           if(feedbacks.size()==0) throw new FeedbackException("Feedback List Empty ");
         		           return feedbacks;
                    	  }
    		      
                       throw new AdminException(" Current User is not a Admin with CurrentUserId "+cuu.getUserId());
                       
    	          }
    	
    	throw new LoginException("Please Login first ");
		
	}
	

}
