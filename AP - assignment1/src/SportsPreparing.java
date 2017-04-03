//Author name is Wen Zhang
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
// This class is focus on supplying original data(Athletes and referee), and offer static method involving computing data for Game.class
public class SportsPreparing {
	public static int swmimmingAmount = 1;
	public static int cyclingAmount = 1;
	public static int runningAmount = 1;
	// Create original data for referee.
	public static Referee creatReferee() {
		Referee rf = new Referee("R1", "Wayne", 31, "VIC");
		return rf;
	}
	// Create original data for athlete and form a ArrayList<Athlete>.
	public static ArrayList<Athlete> creatAllAthletes() {
		Athlete ath1 = new Athlete("A01", "Tim      ", 31, "TAS", "Swimming");
		Athlete ath2 = new Athlete("A02", "Oliver   ", 28, "WA ", "Swimming");
		Athlete ath3 = new Athlete("A03", "Tony     ", 28, "QLD", "Swimming");
		Athlete ath4 = new Athlete("A04", "Abby     ", 29, "NT ", "Swimming");
		Athlete ath5 = new Athlete("A05", "Sid      ", 25, "QLD", "Swimming");
		Athlete ath6 = new Athlete("A06", "Danny    ", 26, "NSW", "Swimming");
		Athlete ath7 = new Athlete("A07", "Barry    ", 23, "VIC", "Running");
		Athlete ath8 = new Athlete("A08", "Allen    ", 24, "TAS", "Running");
		Athlete ath9 = new Athlete("A09", "Dylan    ", 27, "QLD", "Running");
		Athlete ath10 = new Athlete("A10", "Chris    ", 23, "WA ", "Running");
		Athlete ath11 = new Athlete("A11", "Jack     ", 27, "NT ", "Running");
		Athlete ath12 = new Athlete("A12", "Lon      ", 29, "VIC", "Running");
		Athlete ath13 = new Athlete("A13", "Miya     ", 27, "QLD", "Cycling");
		Athlete ath14 = new Athlete("A14", "Toby     ", 22, "TAS", "Cycling");
		Athlete ath15 = new Athlete("A15", "Helvin   ", 26, "SA ", "Cycling");
		Athlete ath16 = new Athlete("A16", "Cara     ", 26, "VIC", "Cycling");
		Athlete ath17 = new Athlete("A17", "Beryl    ", 25, "SA ", "Cycling");
		Athlete ath18 = new Athlete("A18", "Catherine", 25, "NSW", "Cycling");
		Athlete ath19 = new Athlete("A19", "Michael  ", 25, "TAS", "SuperAthlete");
		Athlete ath20 = new Athlete("A20", "Messi    ", 28, "SA ", "SuperAthlete");
		Athlete ath21 = new Athlete("A21", "Neymar   ", 24, "VIC", "SuperAthlete");
		Athlete ath22 = new Athlete("A22", "Patto    ", 25, "NSW", "SuperAthlete");
		Athlete ath23 = new Athlete("A23", "Jerry    ", 26, "VIC", "SuperAthlete");
		Athlete ath24 = new Athlete("A24", "Rooney   ", 30, "TAS", "SuperAthlete");
		ArrayList<Athlete> allAthetes = new ArrayList<Athlete>();
		allAthetes.add(ath1);
		allAthetes.add(ath2);
		allAthetes.add(ath3);
		allAthetes.add(ath4);
		allAthetes.add(ath5);
		allAthetes.add(ath6);
		allAthetes.add(ath7);
		allAthetes.add(ath8);
		allAthetes.add(ath9);
		allAthetes.add(ath10);
		allAthetes.add(ath11);
		allAthetes.add(ath12);
		allAthetes.add(ath13);
		allAthetes.add(ath14);
		allAthetes.add(ath15);
		allAthetes.add(ath16);
		allAthetes.add(ath17);
		allAthetes.add(ath18);
		allAthetes.add(ath19);
		allAthetes.add(ath20);
		allAthetes.add(ath21);
		allAthetes.add(ath22);
		allAthetes.add(ath23);
		allAthetes.add(ath24);
		return allAthetes;
	}
	//Create athletes for different types games, and the amount of athletes for each game is 4~8 randomly.
	public static ArrayList<Athlete> creatAthletes(String type) {

		ArrayList<Athlete> allAthletes = creatAllAthletes();
		Random r = new Random();
		int athletesAmount = r.nextInt(5) + 4;
		ArrayList<Athlete> athletes = new ArrayList<Athlete>();
		while (athletes.size() < athletesAmount) {
			int athleteNum = r.nextInt(allAthletes.size());

			if (allAthletes.get(athleteNum).getType().equals(type)
					|| allAthletes.get(athleteNum).getType().equals("SuperAthlete")) {
				athletes.add(allAthletes.get(athleteNum));
				allAthletes.remove(athleteNum);
			}
		}
		return athletes;
	}
	//Create the objects of competeResult when a new game has been select to run, but no results in it.
	public static ArrayList<CompeteResult> prepareCompeteForm(ArrayList<Athlete> athletes) {
		Iterator<Athlete> i = athletes.iterator();
		ArrayList<CompeteResult> competeForm = new ArrayList<CompeteResult>();
		do {
			competeForm.add(new CompeteResult(i.next()));
		} while (i.hasNext());

		return competeForm;

	}
	//Create object of Swimming with swimmingID, referee(), competeResultForm(no results in it).
	public static Swimming creatSwimming(ArrayList<CompeteResult> competeform) {
		String swimmingID;
		if (swmimmingAmount < 10) {
			swimmingID = "S0" + swmimmingAmount;
		} else {
			swimmingID = "S" + swmimmingAmount;
		}
		Swimming swimming = new Swimming(swimmingID, creatReferee(), competeform);

		swmimmingAmount++;
		return swimming;

	}
	//Create object of Cycling with cyclingID, referee(), competeResultForm(no results in it).
	public static Cycling creatCycling(ArrayList<CompeteResult> competeform) {
		String cyclingID;
		if (cyclingAmount < 10) {
			cyclingID = "C0" + cyclingAmount;
		} else {
			cyclingID = "C" + cyclingAmount;
		}
		Cycling cycling = new Cycling(cyclingID, creatReferee(), competeform);

		cyclingAmount++;
		return cycling;

	}
	//Create object of Running with runningID, referee(), competeResultForm(no results in it).
	public static Running creatRunning(ArrayList<CompeteResult> competeform) {
		String runningID;
		if (runningAmount < 10) {
			runningID = "R0" + runningAmount;
		} else {
			runningID = "R" + runningAmount;
		}
		Running running = new Running(runningID, creatReferee(), competeform);

		runningAmount++;
		return running;

	}
	//select a game to run depending on the type you need, and store the current game data in ArrayList<Sports>
	public static void runGame(String sportType, ArrayList<Sports> allGames) {
		ArrayList<Athlete> athletes = SportsPreparing.creatAthletes(sportType);
		ArrayList<CompeteResult> competeform = SportsPreparing.prepareCompeteForm(athletes);
		if (sportType.equals("Swimming"))
			allGames.add(SportsPreparing.creatSwimming(competeform));
		if (sportType.equals("Cycling"))
			allGames.add(SportsPreparing.creatCycling(competeform));
		if (sportType.equals("Running"))
			allGames.add(SportsPreparing.creatRunning(competeform));
	}
   //To compute the time and rank for each athlete and store in memory.
	public static ArrayList<CompeteResult> presentCompeteResults(Sports sport) {
		Iterator<CompeteResult> iter = sport.getCompeteResults().iterator();
		do {
			iter.next().setTime(sport.computeTime());
		} while (iter.hasNext());

		sport.getCompeteResults().sort(new SortByTime());

		for (int i = 1; i <= sport.getCompeteResults().size(); i++) {
			sport.getCompeteResults().get(i - 1).setRank(i);
		}

		int temp = 1;
		do {

			if (sport.getCompeteResults().get(temp - 1).getTime() == sport.getCompeteResults().get(temp).getTime()) {

				sport.getCompeteResults().get(temp).setRank();

			}
			temp++;
		} while (temp < sport.getCompeteResults().size());

		return sport.getCompeteResults();

	}
    //To save points to all relavent athlete.
	public static ArrayList<Athlete> savePoints(ArrayList<Athlete> allAthlete,
			ArrayList<CompeteResult> competeResults) {
		ArrayList<String> rankFirstIDs = new ArrayList<String>();
		ArrayList<String> rankSecondIDs = new ArrayList<String>();
		ArrayList<String> rankThirdIDs = new ArrayList<String>();
		for (int i = 0; i < competeResults.size(); i++) {
			if (competeResults.get(i).getRank() == 1)
				rankFirstIDs.add(competeResults.get(i).getAthlete().getID());
			if (competeResults.get(i).getRank() == 2)
				rankSecondIDs.add(competeResults.get(i).getAthlete().getID());
			if (competeResults.get(i).getRank() == 3)
				rankThirdIDs.add(competeResults.get(i).getAthlete().getID());
		}

		for (int i = 0; i < allAthlete.size(); i++) {
			if (rankFirstIDs.contains(allAthlete.get(i).getID()))
				allAthlete.get(i).set5Points();
			if (rankSecondIDs.contains(allAthlete.get(i).getID()))
				allAthlete.get(i).set2Points();
			if (rankThirdIDs.contains(allAthlete.get(i).getID()))
				allAthlete.get(i).set1Points();

		}
		return allAthlete;
	}
}
