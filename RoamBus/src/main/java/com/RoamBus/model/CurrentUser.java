package com.RoamBus.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name= "currentUsers")
public class CurrentUser {
	
	@Id
	@Column(unique = true)
	private int userId;
	
	private String uuid;
	
	private Boolean admin;
	
	private LocalDateTime timestamp;

	public CurrentUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CurrentUser(int userId, String uuid, Boolean admin, LocalDateTime timestamp) {
		super();
		this.userId = userId;
		this.uuid = uuid;
		this.admin = admin;
		this.timestamp = timestamp;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "CurrentUser [userId=" + userId + ", uuid=" + uuid + ", admin=" + admin + ", timestamp=" + timestamp
				+ "]";
	}
	
}
