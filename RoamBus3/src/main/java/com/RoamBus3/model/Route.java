package com.RoamBus3.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Route")
public class Route {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private int routeId;
	 
	 @NotNull(message = "Please enter the source of this route")
	 private String routeFrom;
	 
	 @NotNull(message = "Please enter the end route")
	 private String routeTo;
	 
	 @NotNull(message = "Please enter distance")
	 private int distance;
	 
	 @OneToMany(cascade = CascadeType.ALL)
	 private List<Bus> bus;

	public Route() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Route(int routeId, @NotNull(message = "Please enter the source of this route") String routeFrom,
			@NotNull(message = "Please enter the end route") String routeTo,
			@NotNull(message = "Please enter distance") int distance, List<Bus> bus) {
		super();
		this.routeId = routeId;
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
		this.distance = distance;
		this.bus = bus;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
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

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public List<Bus> getBus() {
		return bus;
	}

	public void setBus(List<Bus> bus) {
		this.bus = bus;
	}

	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", routeFrom=" + routeFrom + ", routeTo=" + routeTo + ", distance="
				+ distance + ", bus=" + bus + "]";
	}
	 
	 
	 
}
