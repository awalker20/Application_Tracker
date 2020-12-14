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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Labeled;
import javafx.stage.Stage;

public class DeleteReminderController implements Initializable{
	@FXML
	private Labeled lblDeleteRem;
	
	@FXML
	private Button btnDeleteSubmit;
	
	@FXML
	private ComboBox<String> deleteReminderBox = new ComboBox<String>();
	
	private ObservableList<String> positionData = FXCollections.observableArrayList(ReminderController.getPositionList());
	
	private String valueComboBox;
	
	public void removeReminder(ActionEvent event) throws Exception {
		
		valueComboBox = deleteReminderBox.getValue();
		if (valueComboBox != null) {
			Reminder rem = null;
			rem = Reminder.findRem(valueComboBox);
			
			ReminderController.remove(rem);
			
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/HomePage.fxml"));
			Scene scene = new Scene(root,1050,875);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
	
			// Closes form window
			Stage closingStage =  (Stage)btnDeleteSubmit.getScene().getWindow();
			closingStage.close();
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		deleteReminderBox.setItems(positionData);
		
	}

}
