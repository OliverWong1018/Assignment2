import java.util.ArrayList;
import java.util.Random;

public class Swimming extends Sports {

	public Swimming(String sportsID, Referee referee, ArrayList<Athlete> athletes) {
		super(sportsID, referee, athletes);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compete() {
		
		Random r = new Random();
		
		return r.nextInt(301)+500;
	}

	
	

}
