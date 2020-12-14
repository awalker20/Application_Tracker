package application;


import java.net.URL;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class HomePageController implements Initializable{
	
	@FXML 
	private Label lblContact;
	
	@FXML 
	private Label lblDelete;
	
	@FXML 
	private Button btnApp;
	
	@FXML 
	private Button btnExp;
	
	@FXML 
	private Button btnReminder;
	
	@FXML
	private TextField txtFilter;
	
	@FXML
	private TableView<JobApplication> appTable;
	
	@FXML
	private TableColumn<JobApplication, String> companyColumn;
	
	@FXML
	private TableColumn<JobApplication, String> positionColumn;
	
	@FXML
	private TableColumn<JobApplication, String> dateColumn;
	
	@FXML
	private TableColumn<JobApplication, String> contactName;
	
	@FXML
	private TableColumn<JobApplication, String> contactPhoneNum;
	
	@FXML
	private TableColumn<JobApplication, String> contactEmail;
	
	@FXML
	private TableView<Reminder> reminderTable;

	@FXML
	private TableColumn<Reminder, String> reminderCompanyColumn;
	
	@FXML
	private TableColumn<Reminder, String> reminderPositionColumn;
	
	@FXML
	private TableColumn<Reminder, String> reminderDateColumn;
	
	@FXML
	private TableColumn<Reminder, String> reminderTimeColumn;
	
	@FXML
	private TableColumn<Reminder, String> reminderNotesColumn;

	
	// List to store table elements
	private ObservableList<JobApplication> appData = FXCollections.observableArrayList(JobApplicationController.getAppList());
	private ObservableList<Reminder> remData = FXCollections.observableArrayList(ReminderController.getRemList());


	// Initializes table on the home page
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// Creates column for each Reminder property
		reminderCompanyColumn.setCellValueFactory(new PropertyValueFactory<>("Company"));
		reminderPositionColumn.setCellValueFactory(new PropertyValueFactory<>("Position"));
		reminderDateColumn.setCellValueFactory(new PropertyValueFactory<>("Date"));
		reminderTimeColumn.setCellValueFactory(new PropertyValueFactory<>("Time"));
		reminderNotesColumn.setCellValueFactory(new PropertyValueFactory<>("Notes"));
		
		// Add data to Reminder table to display
		reminderTable.setItems(remData);
		
		// Creates column for each Job Application property
		companyColumn.setCellValueFactory(new PropertyValueFactory<>("Company"));
		positionColumn.setCellValueFactory(new PropertyValueFactory<>("Position"));
		dateColumn.setCellValueFactory(new PropertyValueFactory<>("Date"));
		
		contactName.setCellValueFactory(new PropertyValueFactory<>("Name"));
		contactPhoneNum.setCellValueFactory(new PropertyValueFactory<>("Number"));
		contactEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
		
		// Add data to Job Application table to display
		appTable.setItems(appData);
	}


	// Event that occurs when "Add Application" button is clicked
	public void addApplication(ActionEvent event) throws Exception {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/JobApplicationForm.fxml"));
		Scene scene = new Scene(root,400,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		// closes main window when "Add application" btn is pressed
		Stage refreshJobListStage =  (Stage)btnApp.getScene().getWindow();
		refreshJobListStage.close();
	}
	
	// Event that occurs when "Add Work Experience" button is clicked
	public void showExperience(ActionEvent event) throws Exception {
		Stage experienceStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/WorkExperienceHome.fxml"));
		Scene scene = new Scene(root,1050,875);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		experienceStage.setScene(scene);
		experienceStage.show();
	}
	
	// Event that occurs when "Edit Contact Info" label is clicked
	public void editContactInfo(MouseEvent event) throws Exception {
		if (!appData.isEmpty()) {
		Stage experienceStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/ContactInfoForm.fxml"));
		Scene scene = new Scene(root,400,500);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		experienceStage.setScene(scene);
		experienceStage.show();
		
		// closes main window when "Add application" btn is pressed
		Stage refreshJobListStage =  (Stage)btnExp.getScene().getWindow();
		refreshJobListStage.close();
		}
	}
	
	// Event that occurs when "Add Reminder" button is clicked
		public void addReminder(ActionEvent event) throws Exception {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/ReminderForm.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			// closes main window when "Add reminder" btn is pressed
			Stage refreshJobListStage =  (Stage)btnApp.getScene().getWindow();
			refreshJobListStage.close();
		}	
		
		public void deleteReminder(MouseEvent event) throws Exception {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/DeleteReminderForm.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			// closes main window when "Add reminder" btn is pressed
			Stage refreshJobListStage =  (Stage)btnApp.getScene().getWindow();
			refreshJobListStage.close();
		}
}
