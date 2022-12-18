package com.RoamBus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RoamBus.model.Bus;


@Repository
public interface BusDao  extends JpaRepository<Bus, Integer>{

	
	         public Bus   findBybusName(String name);
	       public List<Bus> findByRouteFromAndRouteTo(String routeFrom, String routeTo);
	       
	       
	      public List<Bus>  findByBusType(String type); 
	       
	       
}
