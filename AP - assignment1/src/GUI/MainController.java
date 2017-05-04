package GUI;

import java.io.IOException;

import javafx.fxml.FXML;

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
   private void GameSwimming(){
		
	}
}
