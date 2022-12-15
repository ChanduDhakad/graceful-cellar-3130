package com.RoamBus3.exception;

import java.time.LocalDateTime;

public class MyErrorDetails {

	private LocalDateTime localDateTime;
	private String message ;
	private String description;
	public MyErrorDetails(LocalDateTime localDateTime, String message, String description) {
		super();
		this.localDateTime = localDateTime;
		this.message = message;
		this.description = description;
	}
	
	
	public MyErrorDetails() {
		// TODO Auto-generated constructor stub
	}

	

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}


	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "MyErrorDetails [localDateTime=" + localDateTime + ", message=" + message + ", description="
				+ description + "]";
	}
	
	
}
