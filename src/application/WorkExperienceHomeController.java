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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class WorkExperienceHomeController implements Initializable {
	
	
	@FXML
	private Button btnSave;
	@FXML
	private Button btnAddExp;
	
	@FXML
	private TableView<WorkExperience> expTable;
	
	@FXML
	private TableColumn<WorkExperience, String> employerColumn;
	
	@FXML
	private TableColumn<WorkExperience, String> titleColumn;
	
	@FXML
	private TableColumn<WorkExperience, String> durationColumn;
	
	private ObservableList<WorkExperience> expData = FXCollections.observableArrayList(WorkExperienceController.getExpList());
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// Creates column for each Work Experience property
		employerColumn.setCellValueFactory(new PropertyValueFactory<>("Employer"));
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("Title"));
		durationColumn.setCellValueFactory(new PropertyValueFactory<>("Duration"));
		
		// Add data to Work Experience table to display
		expTable.setItems(expData);
	}
	
	// Event that occurs when "Add Work Experience" button is clicked
	public void addExperience(ActionEvent event) throws Exception {
		Stage experienceStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/WorkExperienceForm.fxml"));
		Scene scene = new Scene(root,450,500);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		experienceStage.setScene(scene);
		experienceStage.show();
		
		
		// closes main window when "Add application" btn is pressed
		Stage refreshJobListStage =  (Stage)btnAddExp.getScene().getWindow();
		refreshJobListStage.close();
	}

	// Event that occurs when "Add Work Experience" button is clicked
	public void saveExperience(ActionEvent event) throws Exception {

		// closes main window when "Add application" btn is pressed
		Stage refreshJobListStage =  (Stage)btnSave.getScene().getWindow();
		refreshJobListStage.close();
	}
	
}
