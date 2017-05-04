package GUI;

import java.io.IOException;

import javafx.fxml.FXML;

public class ResultController {

	private Main main;

	@FXML
	private void goBack() throws IOException {
		main.showMainPageScene();
	}

}
