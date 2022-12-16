package com.RoamBus.services;

import java.time.LocalDate;
import java.util.List;

import javax.sound.sampled.ReverbType;

import com.RoamBus.access.exception.AdminException;
import com.RoamBus.access.exception.LoginException;
import com.RoamBus.access.exception.UserException;
import com.RoamBus.exception.BusException;
import com.RoamBus.exception.ReservationException;
import com.RoamBus.model.LoginDTO;
import com.RoamBus.model.Reservation;


public interface ReservationService {

	
	
	
	public Reservation addReservation( Reservation res, String key,String busName) throws ReservationException, BusException, LoginException ,UserException; 

	public Reservation updateReservation(Reservation res,  String key,String Bname) throws ReservationException,BusException,LoginException,UserException;

	public Reservation deleteReservation(int reservationId,String key) throws ReservationException, LoginException ;
//	
	
	public Reservation viewReservation(int reservationId,String key) throws ReservationException, BusException, LoginException ,UserException;
	
	
	public List<Reservation> viewAllReservation(String key) throws ReservationException, LoginException, AdminException;

	/*
	public List<Reservation> getAllReservation(LocalDate date,String key) throws ReservationException;
	
	
	
//	public List<Reservation> deleteReservation(int reservationId,String token) throws ReservationException,BusException,LoginException;
	
	*/
	
}
