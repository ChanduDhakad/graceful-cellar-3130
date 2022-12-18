
package com.RoamBus.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userLoginId;
	
	@NotNull(message = "Please enter the username")
	@Size(min = 3, message = "Please enter atleast 3 charecter")
	private String userName;
	
	@NotNull(message = "Please enter the password")
	@Size(max = 15, min = 8, message = "Your password should be at least of 8 charecters and at most of 15 charecters")
	private String password;
	
	@NotNull(message = "Please enter the Firstname")
	private String firstName;
	
	@NotNull(message = "Please enter the lastname")
	private String lastName;
	
	@NotNull(message = "Please enter the contact")
	private long contact;
	
	@NotNull(message = "Please enter the email")
	@Email(message = "Please enter a valid email id")
	private String email;

	
	@OneToOne(cascade = CascadeType.ALL)
	private Reservation reservation;

	
	

}
