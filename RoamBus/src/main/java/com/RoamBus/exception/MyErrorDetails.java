package com.RoamBus.exception;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;

@Controller
public class MyErrorDetails {

	private LocalDateTime localDateTime;
	private String message;
	private String description;

	public MyErrorDetails(LocalDateTime localDateTime, String message, String description) {
		super();
		this.localDateTime = localDateTime;
		this.message = message;
		this.description = description;
	}

	public MyErrorDetails() {
	
	}

	@Override
	public String toString() {
		return "MyErrorDetails [localDateTime=" + localDateTime + ", message=" + message + ", description="
				+ description + "]";
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

}
