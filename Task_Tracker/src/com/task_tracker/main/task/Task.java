package com.task_tracker.main.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
	private int id;
	private String description;
	private String status;
	private String createdAt;
	private String UpdateAt;
	
	public Task() {
		//Empty constructor
	}
	
	public Task(int id, String description) {
		this.id = id;
		this.description = description;
		status = "TODO";
		createdAt = getDateTime();
		UpdateAt = createdAt;		
	}
	
	//Getter and Setter
	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
		setUpdateAt();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public String getUpdateAt() {
		return UpdateAt;
	}

	private void setUpdateAt() {
		this.UpdateAt = getDateTime();
	}

	@Override
	public String toString() {
		return "Task ID                   : "+ getId() +
			 "\nDescription               : "+ getDescription() +
			 "\nStatus                    : "+ getStatus() +
			 "\nCreated Date & Time       : "+ getCreatedAt()+
			 "\nLast Upadated Date & Time : "+ getUpdateAt();
	}

	private String getDateTime() {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
		return dateTime.format(format);
	}

}
