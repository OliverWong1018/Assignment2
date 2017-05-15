package GUI;

import java.net.URL;
import java.util.ResourceBundle;

import io.ReadAllResults;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class ResultsPageController implements Initializable {
	

	@FXML
	public TextArea allResult;

	@FXML
	public Button closeButton;

	@FXML
	private void goBack(ActionEvent event) {
		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();
	}

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		allResult.setText(ReadAllResults.getAllGamesResutls());
		
	}

}
