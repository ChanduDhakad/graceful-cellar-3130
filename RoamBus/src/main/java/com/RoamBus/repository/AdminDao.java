package com.RoamBus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RoamBus.model.Admin;
import com.RoamBus.model.Bus;
import com.RoamBus.model.Feedback;
import com.RoamBus.model.Route;
import com.RoamBus.model.User;


@Repository
public interface AdminDao  extends JpaRepository<Admin, Integer>{

}
