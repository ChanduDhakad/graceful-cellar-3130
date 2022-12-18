package com.RoamBus.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor


@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adminId;
	
	@NotNull(message = "Please enter the username")
	private String adminUsername;
	
	@NotNull(message = "Please Enter the password")
	@Size(max = 15, min = 8, message = "Your password should be at least of 8 charecters and at most of 15 charecters")
	private String password;

	
	

	
	
	

}
