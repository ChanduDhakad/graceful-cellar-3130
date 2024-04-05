package com.RoamBus.services;

import java.util.List;
import com.RoamBus.access.exception.AdminException;
import com.RoamBus.access.exception.LoginException;
import com.RoamBus.access.exception.UserException;
import com.RoamBus.exception.BusException;
import com.RoamBus.exception.ReservationException;
import com.RoamBus.model.Reservation;
public interface ReservationService {	
	public Reservation addReservation( Reservation res, String key,String busName) throws ReservationException, BusException, LoginException ,UserException;
	public Reservation updateReservation(Reservation res,  String key,String Bname) throws ReservationException,BusException,LoginException,UserException;
	public Reservation deleteReservation(int reservationId,String key) throws ReservationException, LoginException ;	
	public Reservation viewReservation(int reservationId,String key) throws ReservationException, BusException, LoginException ,UserException;	
	public List<Reservation> viewAllReservation(String key) throws ReservationException, LoginException, AdminException;
}
