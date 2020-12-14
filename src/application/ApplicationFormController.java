package application;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ApplicationFormController{
	@FXML
	private Button btnAdd;
	
	@FXML
	private Labeled lblJobApplication;
	
	@FXML
	private Labeled lblFilter;
	
	@FXML
	private TextField txtCompany;
	
	@FXML
	private TextField txtPosition;
	
	@FXML
	private TextField txtDate;
	
	// List to store job applications
	public static List<JobApplication> appList = new ArrayList<JobApplication>();

	// List of company names 
	private static List<String> appCompanyList = new ArrayList<String>();
		
	// Getter for the job application list
	public static List<JobApplication>getAppList() {
		return appList;
	}
	
	// Getter for list of company names to populate to combobox on homepage 
	public static List<String> getAppCompanyList() {
		return appCompanyList;
	}
		
	// Occurs when Submit button is clicked on application form
	public void addJob(ActionEvent event) throws Exception {
		
		// Saves inputed text
		String companyStr = txtCompany.getText();
		String positionStr = txtPosition.getText();
		String dateStr = txtDate.getText();
		
		// Creates new job application object
		JobApplication app = new JobApplication(companyStr, positionStr, dateStr, null, null, null);
		
		// Sets the string value to the entered text
		app.setCompanyName(companyStr);
		app.setPosition(positionStr);
		app.setDate(dateStr);
		
		// Add application to application list
		appList.add(app);
		
		// Add company name to list  
		appCompanyList.add(companyStr);
		
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/HomePage.fxml"));
		Scene scene = new Scene(root,625,600);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();

		// Closes form window
		Stage closingStage =  (Stage)btnAdd.getScene().getWindow();
		closingStage.close();
		
		
	}


}
