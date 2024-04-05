package com.RoamBus.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.RoamBus.access.exception.AdminException;
import com.RoamBus.access.exception.LoginException;
import com.RoamBus.exception.FeedbackException;
import com.RoamBus.model.Feedback;
import com.RoamBus.services.FeedbackService;
@RestController
public class FeedbackController {

	@Autowired
	private FeedbackService fbs;

	@PostMapping("/feedback")
	public ResponseEntity<Feedback> addFeedback(@Valid @RequestBody Feedback fs, @RequestParam String key)
			throws LoginException, FeedbackException {
		Feedback feedback = fbs.addFeedBack(fs, key);
		return new ResponseEntity<Feedback>(feedback, HttpStatus.CREATED);
	}
	
	@PutMapping("/feedback")
	public ResponseEntity<Feedback> updateFeedback(@Valid @RequestBody Feedback fs, @RequestParam String key)
			throws LoginException, FeedbackException {
		Feedback feedback = fbs.updateFeedBack(fs, key);
		return new ResponseEntity<Feedback>(feedback, HttpStatus.CREATED);
	}

	@GetMapping("/feedback/{id}")
	public ResponseEntity<Feedback> getFeedback(@Valid @PathVariable int id, @RequestParam String key)
			throws LoginException, FeedbackException {
		Feedback feedback = fbs.viewFeedBack(id, key);
		return new ResponseEntity<Feedback>(feedback, HttpStatus.CREATED);
	}

	@GetMapping("/feedback")
	public ResponseEntity<List<Feedback>> getAllFeedback(@Valid @RequestParam String key)
			throws LoginException, FeedbackException, AdminException {
		List<Feedback> feedback = fbs.viewAllFeedBack(key);
		return new ResponseEntity<List<Feedback>>(feedback, HttpStatus.CREATED);
	}

}
