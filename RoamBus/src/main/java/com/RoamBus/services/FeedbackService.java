package com.RoamBus.services;

import java.util.List;
import com.RoamBus.exception.FeedbackException;
import com.RoamBus.exception.LogException;
import com.RoamBus.model.Feedback;

//import com.RoamBus.model.Feedback;
public interface FeedbackService {
 
	public Feedback addFeedBack(Feedback feedback, Integer Userid) throws LogException;
	
	public Feedback updateFeedBack (Feedback feedback, Integer Userid) throws FeedbackException, LogException;
	
	
	public Feedback viewFeedBack(Integer feedbackid) throws FeedbackException;
	
	public List<Feedback> viewAllFeedBack() throws FeedbackException;
}
