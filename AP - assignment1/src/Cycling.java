import java.util.Random;

public class Cycling extends Sports {

	public Cycling(String sportsID, Referee referee, Athlete[] athletes) {
		super(sportsID, referee, athletes);
	}
/*
 * generate a random time for Cycling from 500 to 800sec.
 * @return
 */
	@Override
	public int compete() {
		
		Random r = new Random();
		
		return r.nextInt(301)+500;
		
	}

	

}
