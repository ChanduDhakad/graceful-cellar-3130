package com.RoamBus3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

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

	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(int adminId, @NotNull(message = "Please enter the username") String adminUsername,
			@NotNull(message = "Please Enter the password") @Size(max = 15, min = 8, message = "Your password should be at least of 8 charecters and at most of 15 charecters") String password) {
		super();
		this.adminId = adminId;
		this.adminUsername = adminUsername;
		this.password = password;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminUsername() {
		return adminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	

}
