package com.team.choix.model;

import java.time.LocalDate;

public class Participant {
	private Long id;
	private String firstName;
	private String lastName;
	private Integer selectionCount;
	private LocalDate lastSelectionDate;
	
	public Participant(Long id, String firstName, String lastName, Integer selectionCount,
			LocalDate lastSelectionDate) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.selectionCount = selectionCount;
		this.lastSelectionDate = lastSelectionDate;
	}
	
	public Participant() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getSelectionCount() {
		return selectionCount;
	}
	public void setSelectionCount(Integer selectionCount) {
		this.selectionCount = selectionCount;
	}
	
	public LocalDate getLastSelectionDate() {
		return lastSelectionDate;
	}
	public void setLastSelectionDate(LocalDate lastSelectionDate) {
		this.lastSelectionDate = lastSelectionDate;
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
}
