package GUI;

import java.io.IOException;

import javafx.fxml.FXML;

public class WelcomeController {
	
	@FXML
	public void goToMainPage() throws IOException{
		
		Main.showMainPageScene();
	}
}
