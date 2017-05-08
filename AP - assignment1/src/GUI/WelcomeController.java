package GUI;

import java.io.IOException;

import javafx.fxml.FXML;
import model.Game;

public class WelcomeController {
	
	@FXML
	public void goToMainPage() throws IOException{
		
		Main.showMainPageScene();
	}
}
