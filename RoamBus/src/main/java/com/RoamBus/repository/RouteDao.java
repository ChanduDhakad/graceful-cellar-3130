package com.RoamBus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RoamBus.model.Route;

public interface RouteDao extends JpaRepository<Route, Integer>{

}
