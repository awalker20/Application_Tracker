package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class JobApplication {
	
	private StringProperty companyName, position, date, name, number, email;
	private ContactInfo contact;
	
				/*Constructor*/
	public JobApplication(String company, String position, String date, String name, String number, String email) {
		companyName = new SimpleStringProperty(company);
		this.position = new SimpleStringProperty(position);
		this.date = new SimpleStringProperty(date);
		this.name = new SimpleStringProperty(name);
		this.number = new SimpleStringProperty(number);
		this.email = new SimpleStringProperty(email);
	}
	
					/*Setters*/

	public void setName(String name) {
	this.name.set(name);
	}
	
	public void setPhone(String number) {
	this.number.set(number);
	}
	
	public void setEmail (String email) {
	this.email.set(email);
	}
	
	public void setCompanyName(String companyName) {
		this.companyName.set(companyName);
	}
	
	public void setPosition(String position) {
		this.position.set(position);
	}
	
	public void setDate(String date) {
		this.date.set(date);
	}
	public void setContact(ContactInfo contact) {
		this.contact = contact;
	}

	
				/*Getters*/
	public ContactInfo getContactInfo() {
		return contact;
	}

	public StringProperty companyProperty() {
		return companyName;
	}	
	
	public StringProperty positionProperty() {
		return position;
	}	
	
	public StringProperty dateProperty() {
		return date;
	}
	public StringProperty contactNameProperty() {
		return name;
	}	
	
	public StringProperty contactPhoneNumProperty() {
		return number;
	}	
	
	public StringProperty contactEmailProperty() {
		return email;
	}
	
	public String getCompany() {
		return companyName.get();
	}	
	
	public String getPosition() {
		return position.get();
	}	
	
	public String getDate() {
		return date.get();
	}	
	
	public String getName() {
		return name.get();
	}	
	
	public String getNumber() {
		return number.get();
	}	
	
	public String getEmail() {
		return email.get();
	}	
	public static JobApplication findApp(String name) {
		JobApplication found = null;
		
		for (JobApplication x : JobApplicationController.getAppList()) {
			if (x.getCompany().equals(name)) {
				found = x;
			}
			else 
				System.out.println("DID NOT WORK");
		}
		return found;
	}

}
