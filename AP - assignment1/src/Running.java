//Author is Wen Zhang
//this class for running with override method from superclass Sports.class
import java.util.ArrayList;
import java.util.Random;

public class Running extends Sports {


	
public Running(String sportsID, Referee referee, ArrayList<CompeteResult> competeResults) {
		super(sportsID, referee, competeResults);
		// TODO Auto-generated constructor stub
	}

	/*
 * generate a random time for Running from 10 to 20sec.
 */
	@Override
	public int computeTime() {
		
		Random r = new Random();
		
		return r.nextInt(11)+10;
	}
}
