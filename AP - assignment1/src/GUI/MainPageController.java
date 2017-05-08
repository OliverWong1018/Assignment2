package GUI;

import java.io.IOException;

import javafx.fxml.FXML;
import model.Game;

public class MainPageController {

	
	@FXML
	private void goResult() throws IOException{
		Main.displayResult();
	}
	
	@FXML
	private void gameOver() throws IOException{
		Main.closeWindow();
	}
	
	@FXML
	private void selectAGame() throws IOException{
		Main.selectGamePage();
	}
}
