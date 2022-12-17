package com.RoamBus.model;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
//@Table(name= "Bus")
public class Bus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int busId;
	
	@NotNull(message = "Please enter the name")
	private String busName;
	
	@NotNull(message = "Please enter the driver name")
	private String driverName;
	
	@NotNull(message = "Please add bus type")
	private String busType;
	
	@NotNull(message = "Please enter the source stop")
	private String routeFrom;
	
	@NotNull(message = "Please enter the destination stop")
	private String routeTo;
	
	private LocalTime depurtureTime;
	
	private LocalTime arrivalTime;
		
	@NotNull(message = "Please enter the total seats")
	private int seats;
	
	private int availableSeats;

	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bus(int busId, @NotNull(message = "Please enter the name") String busName,
			@NotNull(message = "Please enter the driver name") String driverName,
			@NotNull(message = "Please add bus type") String busType,
			@NotNull(message = "Please enter the source stop") String routeFrom,
			@NotNull(message = "Please enter the destination stop") String routeTo, LocalTime arrivalTime,
			LocalTime depurtureTime, @NotNull(message = "Please enter the total seats") int seats, int availableSeats) {
		super();
		this.busId = busId;
		this.busName = busName;
		this.driverName = driverName;
		this.busType = busType;
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
		this.arrivalTime = arrivalTime;
		this.depurtureTime = depurtureTime;
		this.seats = seats;
		this.availableSeats = availableSeats;
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getRouteFrom() {
		return routeFrom;
	}

	public void setRouteFrom(String routeFrom) {
		this.routeFrom = routeFrom;
	}

	public String getRouteTo() {
		return routeTo;
	}

	public void setRouteTo(String routeTo) {
		this.routeTo = routeTo;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public LocalTime getDepurtureTime() {
		return depurtureTime;
	}

	public void setDepurtureTime(LocalTime depurtureTime) {
		this.depurtureTime = depurtureTime;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", busName=" + busName + ", driverName=" + driverName + ", busType=" + busType
				+ ", routeFrom=" + routeFrom + ", routeTo=" + routeTo + ", arrivalTime=" + arrivalTime
				+ ", depurtureTime=" + depurtureTime + ", seats=" + seats + ", availableSeats=" + availableSeats + "]";
	}
	
	
	
}
