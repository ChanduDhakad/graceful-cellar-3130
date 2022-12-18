package com.RoamBus.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor


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

	
	
	 
	 
	 
}
