//Author is Wen Zhang
//this class for swimming with override method from superclass Sports.class

import java.util.ArrayList;
import java.util.Random;

public class Swimming extends Sports {

	

	

	public Swimming(String sportsID, Referee referee, ArrayList<CompeteResult> competeResults) {
		super(sportsID, referee, competeResults);
		// TODO Auto-generated constructor stub
	}

	/*
 * generate a random time for swimming game from 100 to 200sec.
 */
	@Override
	public int computeTime() {		
		Random r = new Random();
		
		return r.nextInt(101)+100;

	}

}
