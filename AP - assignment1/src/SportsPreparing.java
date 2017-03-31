import java.util.ArrayList;
import java.util.Random;

public class SportsPreparing {
	public static int swmimmingAmount = 1;
	public static Referee creatReferee(){
		Referee rf = new Referee("R1", "Wayne", 31, "VIC");
		return rf;
	}
	public static ArrayList<Athlete> creatAllAthletes(){
		Athlete ath1 = new Athlete("A1", "Tim", 31, "TAS", "Swimming");
		Athlete ath2 = new Athlete("A2", "Oliver", 28, "WA", "Swimming" );
		Athlete ath3 = new Athlete("A3", "Tony", 28, "QLD", "Swimming");
		Athlete ath4 = new Athlete("A4", "Abby", 29, "NT", "Swimming");
		Athlete ath5 = new Athlete("A5", "Sid", 25, "QLD", "Swimming");
		Athlete ath6 = new Athlete("A6", "Danny", 26, "NSW", "Swimming");
		Athlete ath7 = new Athlete("A7", "Barry", 23, "VIC", "Running");
		Athlete ath8 = new Athlete("A8", "Allen", 24, "TAS", "Running");
		Athlete ath9 = new Athlete("A9", "Dylan", 27, "QLD", "Running");
		Athlete ath10 = new Athlete("A10", "Chris", 23, "WA", "Running");
		Athlete ath11 = new Athlete("A11", "Jack", 27, "NT", "Running");
		Athlete ath12 = new Athlete("A12", "Lon", 29, "VIC", "Running");
		Athlete ath13 = new Athlete("A13", "Miya", 27, "QLD", "Cycling");
		Athlete ath14 = new Athlete("A14", "Toby", 22, "TAS", "Cycling");
		Athlete ath15 = new Athlete("A15", "Helvin", 26, "SA", "Cycling");
		Athlete ath16 = new Athlete("A16", "Cara", 26, "VIC", "Cycling");
		Athlete ath17 = new Athlete("A17", "Beryl", 25, "SA", "Cycling");
		Athlete ath18 = new Athlete("A18", "Catherine", 25, "NSW", "Cycling");
		Athlete ath19 = new Athlete("A19", "Michael", 25, "TAS", "SuperAthlete");
		Athlete ath20 = new Athlete("A20", "Messi", 28, "SA", "SuperAthlete");
		Athlete ath21 = new Athlete("A21", "Neymar", 24, "VIC", "SuperAthlete");
		Athlete ath22 = new Athlete("A22", "Patto", 25, "NSW", "SuperAthlete");
		Athlete ath23 = new Athlete("A23", "Jerry", 26, "VIC", "SuperAthlete");
		Athlete ath24 = new Athlete("A24", "Rooney", 30, "TAS", "SuperAthlete");
		ArrayList<Athlete> allAthetes = new ArrayList<Athlete>();
		allAthetes.add(ath1);allAthetes.add(ath2);allAthetes.add(ath3);allAthetes.add(ath4);allAthetes.add(ath5);allAthetes.add(ath6);
		allAthetes.add(ath7);allAthetes.add(ath8);allAthetes.add(ath9);allAthetes.add(ath10);allAthetes.add(ath11);allAthetes.add(ath12);
		allAthetes.add(ath13);allAthetes.add(ath14);allAthetes.add(ath15);allAthetes.add(ath16);allAthetes.add(ath17);allAthetes.add(ath18);
		allAthetes.add(ath19);allAthetes.add(ath20);allAthetes.add(ath21);allAthetes.add(ath22);allAthetes.add(ath23);allAthetes.add(ath24);
		return allAthetes;
	}
	
	public static ArrayList<Athlete> creatAthletes(String type){
		
		ArrayList<Athlete> allAthletes = creatAllAthletes();
		Random r = new Random();
		int athletesAmount = r.nextInt(5)+4;
		ArrayList<Athlete> swimmer = new ArrayList<Athlete>();	
		for(int i = 0;i<athletesAmount;i++){
			int athleteNum = r.nextInt(25);
			if(allAthletes.get(athleteNum).getType().equals(type)||allAthletes.get(athleteNum).getType().equals("SuperAthlete")){
				swimmer.add(allAthletes.get(athleteNum));
			}else{
				continue;
			}
		}
		return swimmer;
				
	}
	public static Swimming creatSwimming(){
		String swimmingID;
		if(swmimmingAmount<10){
		 	swimmingID ="S0" + swmimmingAmount;
		}else{
			swimmingID = "S"+swmimmingAmount;
			}
		Swimming swimming  = new Swimming(swimmingID, creatReferee(), creatAthletes("Swimming"));
		
		swmimmingAmount++;
		return swimming;
		
	}
	
}
