package com.RoamBus.services;

import java.util.List;

import com.RoamBus.access.exception.AdminException;
import com.RoamBus.access.exception.LoginException;
import com.RoamBus.exception.FeedbackException;

import com.RoamBus.model.Feedback;

public interface FeedbackService {

	public Feedback addFeedBack(Feedback feedback , String Key) throws LoginException,FeedbackException;
	
	public Feedback updateFeedBack(Feedback feedback , String Key) throws LoginException,FeedbackException;
//	public Feedback upFeedBack(Feedback feedback , int UserId, String Key) throws LoginException,FeedbackException;
	public Feedback viewFeedBack(int feedbackId ,  String Key) throws LoginException,FeedbackException;
	public List<Feedback> viewAllFeedBack( String Key) throws LoginException,FeedbackException, AdminException;
	
}
