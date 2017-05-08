package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ResultController {

	
	@FXML
	public Button closeButton;
	
	@FXML
	private void goBack(ActionEvent event){
		Stage stage = (Stage) closeButton.getScene().getWindow();
	    stage.close();
	}

}
