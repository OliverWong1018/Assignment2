package GUI;

import java.io.IOException;

import javafx.fxml.FXML;

public class SelectGamePageController {

	@FXML
	public void swimmingGame() throws IOException {
		Main.currentGameType = "S";
		Main.showConstructGamePageScene();
	}
	@FXML
	public void runningGame() throws IOException {
		Main.currentGameType = "R";
		Main.showConstructGamePageScene();
	}
	@FXML
	public void cyclingGame() throws IOException {
		Main.currentGameType = "C";
		Main.showConstructGamePageScene();
	}
}
