package GUI;

import java.io.IOException;

import javafx.fxml.FXML;

public class SelectGamePageController {

	@FXML
	public void swimmingGame() throws IOException {
		Main.currentGameType = "s";
		Main.showConstructGamePageScene();
	}
	@FXML
	public void runningGame() throws IOException {
		Main.
		Main.showConstructGamePageScene();
	}
	@FXML
	public void cyclingGame() throws IOException {

		Main.showConstructGamePageScene();
	}
}
