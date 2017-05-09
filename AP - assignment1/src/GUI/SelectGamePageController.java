package GUI;

import java.io.IOException;

import javafx.fxml.FXML;


public class SelectGamePageController {
	
	@FXML
	public void goBack() throws IOException{
		Main.showMainPageScene();
	
	}
	@FXML
	public void constructGame() throws IOException{
		
		Main.showConstructGamePageScene();
	}
}
