package com.RoamBus.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;


@Entity
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int feedbackId;
	
	@NotNull(message = "Please give our driver a rating as per your experience")
	private int driverRating;
	
	@NotNull(message = "Please give our service a rating as per your experience")
	private int serviceRating;
	
	@NotNull(message = "Please give our overall a rating as per your experience")
	private int overallRating;
	
	private String comments;
	
	private LocalDate feedback;
	
	@Embedded
	private User user;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Bus bus;

	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Feedback(int feedbackId,
			@NotNull(message = "Please give our driver a rating as per your experience") int driverRating,
			@NotNull(message = "Please give our service a rating as per your experience") int serviceRating,
			@NotNull(message = "Please give our overall a rating as per your experience") int overallRating,
			String comments, LocalDate feedback, User user, Bus bus) {
		super();
		this.feedbackId = feedbackId;
		this.driverRating = driverRating;
		this.serviceRating = serviceRating;
		this.overallRating = overallRating;
		this.comments = comments;
		this.feedback = feedback;
		this.user = user;
		this.bus = bus;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public int getDriverRating() {
		return driverRating;
	}

	public void setDriverRating(int driverRating) {
		this.driverRating = driverRating;
	}

	public int getServiceRating() {
		return serviceRating;
	}

	public void setServiceRating(int serviceRating) {
		this.serviceRating = serviceRating;
	}

	public int getOverallRating() {
		return overallRating;
	}

	public void setOverallRating(int overallRating) {
		this.overallRating = overallRating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public LocalDate getFeedback() {
		return feedback;
	}

	public void setFeedback(LocalDate feedback) {
		this.feedback = feedback;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", driverRating=" + driverRating + ", serviceRating="
				+ serviceRating + ", overallRating=" + overallRating + ", comments=" + comments + ", feedback="
				+ feedback + ", user=" + user + ", bus=" + bus + "]";
	}
	
	
	
}
