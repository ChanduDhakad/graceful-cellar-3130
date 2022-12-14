package com.RoamBus.model;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Bus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int busId;
	
	@NotNull(message = "Please enter the bus name")
	private String busName;
	
	@NotNull(message = "Please enter the bus type")
	private String busType;
	
	@NotNull(message = "Please let us know your source of destination")
	private String routeFrom;
	
	@NotNull(message = "Please tell us your destination")
	private String routeTo;
	
	private LocalTime arrivalTime;
	private LocalTime departureTime;
	
	@NotNull(message = "How many seats you have still we don't know")
	@Min(value = 30, message = "Minimum seats should be 30")
	@Max(value = 100, message = "Your bus capacity at most should be 100")
	private int seats;
	
	@NotNull(message = "Can not be null")
	@Max(value = 100, message = "Your seat availability can not be beyond 100")
	@Min(value = 0, message = "you can't put a negetive value")
	private int avilableSeats;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Feedback feedback;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Reservation reservation;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Route> routes;

	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bus(int busId, @NotNull(message = "Please enter the bus name") String busName,
			@NotNull(message = "Please enter the bus type") String busType,
			@NotNull(message = "Please let us know your source of destination") String routeFrom,
			@NotNull(message = "Please tell us your destination") String routeTo, LocalTime arrivalTime,
			LocalTime departureTime,
			@NotNull(message = "How many seats you have still we don't know") @Min(value = 30, message = "Minimum seats should be 30") @Max(value = 100, message = "Your bus capacity at most should be 100") int seats,
			@NotNull(message = "Can not be null") @Max(value = 100, message = "Your seat availability can not be beyond 100") @Min(value = 0, message = "you can't put a negetive value") int avilableSeats,
			Feedback feedback, Reservation reservation, List<Route> routes) {
		super();
		this.busId = busId;
		this.busName = busName;
		this.busType = busType;
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.seats = seats;
		this.avilableSeats = avilableSeats;
		this.feedback = feedback;
		this.reservation = reservation;
		this.routes = routes;
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

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public int getAvilableSeats() {
		return avilableSeats;
	}

	public void setAvilableSeats(int avilableSeats) {
		this.avilableSeats = avilableSeats;
	}

	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public List<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}

	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", busName=" + busName + ", busType=" + busType + ", routeFrom=" + routeFrom
				+ ", routeTo=" + routeTo + ", arrivalTime=" + arrivalTime + ", departureTime=" + departureTime
				+ ", seats=" + seats + ", avilableSeats=" + avilableSeats + ", feedback=" + feedback + ", reservation="
				+ reservation + ", routes=" + routes + "]";
	}
	
	
}
