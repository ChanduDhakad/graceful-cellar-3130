
package com.RoamBus.model;

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

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Reservation reservation;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userLoginId,
			@NotNull(message = "Please enter the username") @Size(min = 3, message = "Please enter atleast 3 charecter") String userName,
			@NotNull(message = "Please enter the password") @Size(max = 15, min = 8, message = "Your password should be at least of 8 charecters and at most of 15 charecters") String password,
			@NotNull(message = "Please enter the Firstname") String firstName,
			@NotNull(message = "Please enter the lastname") String lastName,
			@NotNull(message = "Please enter the contact") long contact,
			@NotNull(message = "Please enter the email") @Email(message = "Please enter a valid email id") String email,
			Reservation reservation) {
		super();
		this.userLoginId = userLoginId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.email = email;
//		this.reservation = reservation;
	}

	public int getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(int userLoginId) {
		this.userLoginId = userLoginId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


//	public Reservation getReservation() {
//		return reservation;
//	}
//
//	public void setReservation(Reservation reservation) {
//		this.reservation = reservation;
//	}

//	@Override
//	public String toString() {
//		return "User [userLoginId=" + userLoginId + ", userName=" + userName + ", password=" + password + ", firstName="
//				+ firstName + ", lastName=" + lastName + ", contact=" + contact + ", email=" + email + ", reservation="
//				+ reservation + "]";
//	}
	

}
