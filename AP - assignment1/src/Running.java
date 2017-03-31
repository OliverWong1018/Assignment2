import java.util.Random;

public class Running extends Sports {

	public Running(String sportsID, Referee referee, Athlete[] athletes) {
		super(sportsID, referee, athletes);
		// TODO Auto-generated constructor stub
	}
/*
 * generate a random time for Running from 10 to 20sec.
 */
	@Override
	public int compete() {
		
		Random r = new Random();
		
		return r.nextInt(11)+10;
	}
}
