package GUI;

import java.io.IOException;

import javafx.fxml.FXML;
import model.Game;

public class MainController {

	private Main main;

	@FXML
	private void goMainPage() throws IOException {
		main.showMainPageScene();
		
	}
	
	@FXML
	private void goResult() throws IOException{
		main.displayResult();
	}
	
	@FXML
	private void gameOver() throws IOException{
		main.closeWindow();
	}
	
	@FXML
	private void swimmingGame() throws IOException{
		Game game = new Game();
		game.begin();
		game.selectGame();
	}
}
