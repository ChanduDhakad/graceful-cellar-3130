package com.RoamBus3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.RoamBus3.model.CurrentUser;

@Repository
public interface CurrentUserDao extends JpaRepository<CurrentUser, Integer> {
	
	public CurrentUser findByUuid(String uuid);

}
