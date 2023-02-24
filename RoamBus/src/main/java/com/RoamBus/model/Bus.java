package com.RoamBus.model;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
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

	
//	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
	private LocalTime depurtureTime;
	
//	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
	private LocalTime arrivalTime;
		
	@NotNull(message = "Please enter the total seats")
	@Size(min = 10, max = 50, message = "Seats Number should be 10 to 50")
	private int seats;

	@NotNull(message = "Please Enter available seats")
	private int availableSeats;

	
	
	
	
	
}
