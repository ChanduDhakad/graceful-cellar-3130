package com.RoamBus.exception;

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
	
}
