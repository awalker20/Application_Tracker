package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Reminder {
	private StringProperty company, position, date, time, notes;
	
		/*Constructor*/
	public Reminder(String company, String position, String date, String time, String notes) {
		this.company = new SimpleStringProperty(company);
		this.position = new SimpleStringProperty(position);
		this.date = new SimpleStringProperty(date);
		this.time = new SimpleStringProperty(time);
		this.notes = new SimpleStringProperty(notes);
	}
	
		/*Setters*/
	public void setCompany(String company) {
		this.company.set(company);
	}
	
	public void setPosition(String position) {
	this.position.set(position);
	}
	
	public void setDate(String date) {
	this.date.set(date);
	}
	
	public void setTime(String time) {
	this.time.set(time);
	}
	
	public void setNotes(String notes) {
	this.notes.set(notes);
	}
	
		/*Getters*/

	public StringProperty companyProperty() {
		return company;
	}	
	
	public StringProperty positionProperty() {
		return position;
	}	
	
	public StringProperty dateProperty() {
		return date;
	}	
	
	public StringProperty timeProperty() {
		return time;
	}	
	
	public StringProperty notesProperty() {
		return notes;
	}
	

	public String getCompany() {
		return company.get();
	}
	
	public String getPosition() {
		return position.get();
	}	
	
	public String getDate() {
		return date.get();
	}	
	
	public String getTime() {
	return time.get();
	}	
	
	public String getNotes() {
		return notes.get();
	}	

	public static Reminder findRem(String name) {
		Reminder found = null;
		
		for (Reminder x : ReminderController.getRemList()) {
			if (x.getPosition().equals(name)) {
				found = x;
			}
			else 
				System.out.println("DID NOT WORK");
		}
		return found;
	}

}
