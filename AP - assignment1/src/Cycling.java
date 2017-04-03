//Author is Wen Zhang
//this class for cycling with override method from superclass Sports.class.
import java.util.ArrayList;
import java.util.Random;

public class Cycling extends Sports {

	

	
public Cycling(String sportsID, Referee referee, ArrayList<CompeteResult> competeResults) {
		super(sportsID, referee, competeResults);
		// TODO Auto-generated constructor stub
	}

/*
 * generate a random time for Cycling from 500 to 800sec.
 * @return
 */
	@Override
	public int computeTime() {
		
		Random r = new Random();
		
		return r.nextInt(301)+500;
		
	}

	

}
