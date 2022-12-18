package com.RoamBus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RoamBus.model.Bus;
import com.RoamBus.model.Feedback;
import com.RoamBus.model.Reservation;
import com.RoamBus.model.Route;



@Repository
public interface ReservationDao  extends JpaRepository<Reservation, Integer>{

}
