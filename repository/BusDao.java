package com.RoamBus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RoamBus.model.Bus;


@Repository
public interface BusDao  extends JpaRepository<Bus, Integer>{

}
