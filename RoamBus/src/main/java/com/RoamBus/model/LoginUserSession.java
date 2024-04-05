package com.RoamBus.model;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


   
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LoginUserSession {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String email;
	private String password;
	
}
