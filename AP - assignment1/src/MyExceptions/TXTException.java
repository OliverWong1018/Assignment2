package MyExceptions;

import javafx.scene.control.Label;

public class TXTException extends Exception {
	
	   public TXTException(String errMsg, Label notice) {
	      super(errMsg); 
	      notice.setText("The TXT connection doesn't work well now, and Database will work instead");
	   } 
	}
