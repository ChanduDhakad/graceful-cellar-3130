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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reservationId;

	private String status;

	@NotNull(message = "Please enter add the type")
	private String Type;

	private LocalDate localDate;
	private LocalTime time;

	@NotNull(message = "Please tell us your source location")
	private String source;

	@NotNull(message = "Please tell us your destination")
	private String destination;

	@OneToOne(cascade = CascadeType.ALL)
	private Bus bus;

	@OneToOne(cascade = CascadeType.ALL)
	private User user;

}
