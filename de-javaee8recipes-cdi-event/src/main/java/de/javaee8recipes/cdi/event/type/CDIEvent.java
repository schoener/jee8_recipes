package de.javaee8recipes.cdi.event.type;

import java.io.Serializable;
import java.time.LocalDate;

public class CDIEvent implements Serializable {
	private static final long serialVersionUID = 1L;
	private String action;
	private LocalDate date;

	public CDIEvent(String action, LocalDate date) {
		this.action = action;
		this.date = date;
	}
	
	public CDIEvent() {}

	public String getAction() {
		return action;
	}

	public LocalDate getDate() {
		return date;
	}
	
	public void setAction(String action) {
		this.action = action;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Event with action " + action + " on date " + date;
	}
}
