package com.RoamBus.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

public class Route {

	private int routeId;
	private String routeFrom;
	private String routeTo;
	private int distance;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Bus> bus;

	public Route() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Route(int routeId, String routeFrom, String routeTo, int distance, List<Bus> bus) {
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
