package MyExceptions;

import javafx.scene.control.Label;

public class DBException extends Exception {
	
	   public DBException(String errMsg, Label notice) {
	      super(errMsg); 
	      notice.setText("The DataBase connection doesn't work well now, and TXT will work instead");
	   } 
	}
