import java.util.ArrayList;
import java.util.Random;

public class Running extends Sports {


	public Running(String sportsID, Referee referee, ArrayList<Athlete> athletes) {
		super(sportsID, referee, athletes);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compete() {
		
		Random r = new Random();
		
		return r.nextInt(11)+10;
	}
}
