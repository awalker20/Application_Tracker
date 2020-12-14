package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ContactInfo {
	
	private StringProperty contactName, contactEmail, contactPhone;
	
	
		/*Constructor*/
	public ContactInfo(String contactName, String contactEmail, String contactPhone) {
	this.contactName = new SimpleStringProperty(contactName);
	this.contactEmail = new SimpleStringProperty(contactEmail);
	this.contactPhone = new SimpleStringProperty(contactPhone);
	
	}
	
			/*Setters*/
	public void setName(String contactName) {
	this.contactName.set(contactName);
	}
	
	public void setEmail(String contactEmail) {
	this.contactEmail.set(contactEmail);
	}
	
	public void setPhone(String contactPhone) {
	this.contactPhone.set(contactPhone);
	}
	
		/*Getters*/
	
	public String getName() {
	return contactName.get();
	}	
	
	public String getEmail() {
	return contactEmail.get();
	}	
	
	public String getPhone() {
	return contactPhone.get();
	}	

	

}
