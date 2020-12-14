package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ContactInfoController implements Initializable {
	@FXML
	private Button btnContact;
	
	@FXML
	private Labeled lblContact;
	
	@FXML
	private TextField txtName;
	
	@FXML
	private TextField txtPhone;
	
	@FXML
	private TextField txtEmail;
	
	private ObservableList<String> appData = FXCollections.observableArrayList(JobApplicationController.getAppCompanyList());
	
	private ObservableList<JobApplication> jobData = FXCollections.observableArrayList(JobApplicationController.getAppList());
	
	@FXML
	private ComboBox<String> contactBox = new ComboBox<String>(appData);

	private String valueComboBox;

	// List of Contact info (Name, Phone #, Email)
	private static List<ContactInfo> appContactList = new ArrayList<ContactInfo>();
	
	// Getter for list of Contact info to populate columns on homepage 
	public static List<ContactInfo> getAppContactList() {
		return appContactList;
	}
	
	// Occurs when Submit button is clicked on contact info form
	public void addContactInfo(ActionEvent event) throws Exception {
		
		// Saves inputed text
		String nameStr = txtName.getText();
		String phoneStr = txtPhone.getText();
		String emailStr = txtEmail.getText();
		valueComboBox = contactBox.getValue();
		if (valueComboBox != null) {
			JobApplication updateJob = null;
			
			// Creates new job application object
			ContactInfo contact = new ContactInfo(nameStr, phoneStr, emailStr);
			
			// Sets the string value to the entered text
			contact.setName(nameStr);
			contact.setEmail(emailStr);
			contact.setPhone(phoneStr);
			
			appContactList.add(contact);
			updateJob = JobApplication.findApp(valueComboBox);
			updateJob.setName(nameStr);
			updateJob.setPhone(phoneStr);
			updateJob.setEmail(emailStr);
			
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/HomePage.fxml"));
			Scene scene = new Scene(root,1050,875);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
	
			// Closes form window
			Stage closingStage =  (Stage)btnContact.getScene().getWindow();
			closingStage.close();
		}
		
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		contactBox.setItems(appData);
	}
	

}
