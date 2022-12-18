package com.RoamBus.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "currentUsers")
public class CurrentUser {
	
	@Id
	@Column(unique = true)
	private int userId;
	
	private String uuid;
	
	private Boolean admin;
	
	private LocalDateTime timestamp;

}
