package com.RoamBus.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reservationId;
	
//	@NotNull(message = "Please update the status")
	private String status;
	
	@NotNull(message = "Please enter add the type")
	private String Type;
	
	private LocalDate localDate;
	private LocalTime time;
	
//	@NotNull(message = "Please tell us your source location")
	private String source;
	
//	@NotNull(message = "Please tell us your destination")
	private String destination;
	
      //@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Bus bus;
      
     // @JsonIgnore
  	@OneToOne(cascade = CascadeType.ALL)
  	private User user;

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(int reservationId, @NotNull(message = "Please update the status") String status,
			@NotNull(message = "Please enter add the type") String type,
			@NotNull(message = "Please tell us your source location") String source,
			@NotNull(message = "Please tell us your destination") String destination, Bus bus) {
		super();
		this.reservationId = reservationId;
		this.status = status;
		this.Type = type;
		this.localDate = localDate;
		this.time = time.now();
		this.source = source;
		this.destination = destination;
//		this.bus = bus;
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public LocalDate getLocalDate() {
		return localDate.now();
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate.now();
	}

	public LocalTime getTime() {
		return time.now();
	}

	public void setTime(LocalTime time) {
		this.time = time.now();
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", status=" + status + ", Type=" + Type + ", localDate="
				+ localDate + ", time=" + time + ", source=" + source + ", destination=" + destination + ", bus=" + bus
				+ ", user=" + user + "]";
	}


	
	
	
	
}
