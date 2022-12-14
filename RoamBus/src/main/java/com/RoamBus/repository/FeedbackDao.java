package com.RoamBus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RoamBus.model.Bus;
import com.RoamBus.model.Feedback;


@Repository
public interface FeedbackDao  extends JpaRepository<Feedback, Integer>{

}
