package com.RoamBus3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RoamBus3.model.Bus;

public interface BusDao extends JpaRepository<Bus, Integer> {
	
	public Bus findByBusName(String bname);
	
	public List<Bus> findByRouteFromAndRouteTo(String routeFrom, String routeTo);
}
