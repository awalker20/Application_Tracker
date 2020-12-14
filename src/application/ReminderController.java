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

public class ReminderController implements Initializable{
	@FXML
	private Labeled lblContact;
	
	@FXML
	private Button btnSubmit;
	
	@FXML
	private TextField txtDate;
	
	@FXML
	private TextField txtTime;
	
	@FXML
	private TextField txtNotes;

	private ObservableList<String> appData = FXCollections.observableArrayList(JobApplicationController.getAppCompanyList());
	
	@FXML
	private ComboBox<String> reminderBox = new ComboBox<String>(appData);

	private String valueComboBox;
	
	private static List<String> positionList = new ArrayList<String>();
	
	public static List<String> getPositionList(){
		return positionList;
	}
	
	private static List<Reminder> remList = new ArrayList<Reminder>();
	
	// Getter for the job application list
	public static List<Reminder> getRemList(){
		return remList;
	}

//Occurs when Submit button is clicked on contact info form
	public void addReminder(ActionEvent event) throws Exception {
		
		// Saves inputed text
		String dateStr = txtDate.getText();
		String timeStr = txtTime.getText();
		String notesStr = txtNotes.getText();
		valueComboBox = reminderBox.getValue();
		if (valueComboBox != null) {
			JobApplication job = null;
			job = JobApplication.findApp(valueComboBox);
			
			String positionStr = job.getPosition();
			positionList.add(positionStr);
			
			String companyStr = job.getCompany();
			
			// Creates new job application object
			Reminder form = new Reminder(companyStr, positionStr, dateStr, timeStr, notesStr);
			
			// Sets the string value to the entered text
			form.setCompany(companyStr);
			form.setPosition(positionStr);
			form.setDate(dateStr);
			form.setTime(timeStr);
			form.setNotes(notesStr);
			
			remList.add(form);
			
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/HomePage.fxml"));
			Scene scene = new Scene(root,1050,875);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

			// Closes form window
			Stage closingStage =  (Stage)btnSubmit.getScene().getWindow();
			closingStage.close();
		}
		
		
	}
	
	public static void remove (Reminder r) {
		remList.remove(r);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		reminderBox.setItems(appData);
	}
}