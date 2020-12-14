package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class WorkExperience {
	
	private StringProperty employer, title, duration;
	
				/*Constructor*/
	public WorkExperience(String employer, String title, String duration) {
		this.employer = new SimpleStringProperty(employer);
		this.title = new SimpleStringProperty(title);
		this.duration = new SimpleStringProperty(duration);
	}
	
					/*Setters*/
	public void setEmployerName(String employer) {
		this.employer.set(employer);
	}
	
	public void setTitle(String title) {
		this.title.set(title);
	}
	
	public void setDuration(String duration) {
		this.duration.set(duration);
	}

	
				/*Getters*/
	public StringProperty employerProperty() {
		return employer;
	}	
	
	public StringProperty tileProperty() {
		return title;
	}	
	
	public StringProperty durationProperty() {
		return duration;
	}
	
	public String getEmployer() {
		return employer.get();
	}	
	
	public String getTitle() {
		return title.get();
	}	
	
	public String getDuration() {
		return duration.get();
	}	
}
