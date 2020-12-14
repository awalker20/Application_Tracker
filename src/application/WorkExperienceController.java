package application;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class WorkExperienceController {

	@FXML
	private Button btnExp;
	
	@FXML
	private Label lblExperience;
	
	@FXML
	private TextField txtEmployer;
	
	@FXML
	private TextField txtTitle;
	
	@FXML
	private TextField txtDuration;
	
	// List to store job applications
	private static List<WorkExperience> expList = new ArrayList<WorkExperience>();
	
	
	// Getter for the job application list
	public static List<WorkExperience>getExpList(){
		return expList;
	}
	
	
	public void addExperience(ActionEvent event) throws Exception {
		
		// Saves inputed text
		String employerStr = txtEmployer.getText();
		String titleStr = txtTitle.getText();
		String durationStr = txtDuration.getText();

		
		// Creates new job application object
		WorkExperience exp = new WorkExperience(employerStr, titleStr, durationStr);

		
		// Sets the string value to the entered text
		exp.setEmployerName(employerStr);
		exp.setTitle(titleStr);
		exp.setDuration(durationStr);
				// Add application to application list
		expList.add(exp);
		
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/WorkExperienceHome.fxml"));
		Scene scene = new Scene(root,1050,875);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();

		// Closes form window
		Stage closingStage =  (Stage)btnExp.getScene().getWindow();
		closingStage.close();
		
		
	}
	
}
