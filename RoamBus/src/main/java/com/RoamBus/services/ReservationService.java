package com.RoamBus.services;

import java.util.List;

import javax.sound.sampled.ReverbType;

import com.RoamBus.access.exception.LoginException;
import com.RoamBus.access.exception.UserException;
import com.RoamBus.exception.BusException;
import com.RoamBus.exception.ReservationException;
import com.RoamBus.model.Reservation;

public interface ReservationService {

	public Reservation addReservation(Reservation reservation,int busId,String token) throws ReservationException,BusException,LoginException; 
	
	public Reservation updateReservation(Reservation reservation,int reserveId,String token) throws ReservationException,BusException,LoginException,UserException;
	
	public Reservation deleteReservation(int reservationId,String token) throws ReservationException,BusException,LoginException;
	
	public Reservation viewReservation(int reservationId,String token) throws ReservationException,UserException;
	
	
	
	
	
//	public List<Reservation> deleteReservation(int reservationId,String token) throws ReservationException,BusException,LoginException;
	
	
	
}
