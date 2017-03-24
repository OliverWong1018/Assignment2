import java.util.Random;

public class Cycling extends Sports {

	public Cycling(String sportsID, Referee referee, Athlete[] athletes) {
		super(sportsID, referee, athletes);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compete() {
		
		Random r = new Random();
		
		return r.nextInt(101)+100;
		
	}

	

}
