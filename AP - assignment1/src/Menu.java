import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;



public class Menu {

	private Scanner sc = new Scanner(System.in);
	private ArrayList<Sports> allGames = new ArrayList<Sports>();
	
	
	
	  //Generate a menu for Ozlymic Game
	 
	public void mainMenu() {
		int choice = 0;

		//do {
			//try {
				System.out.println("             Ozlympic Game");
				System.out.println("===========================================");
				System.out.println("1. Select a game to run");
				System.out.println("2. Predict the winner of the game");
				System.out.println("3. Start the game");
				System.out.println("4. Display the final results of all games");
				System.out.println("5. Display the points of all athletes");
				System.out.println("6. Exit");
				System.out.println("");
				System.out.println("Enter an option: ");
				choice = sc.nextInt();

				System.out.println(" ");

				if (choice > 6 || choice < 0) {
					System.out.println("Error Number!!! Please choose 1 to 6.");
				} else {
					switch (choice) {
					case 1:
						selectGame();
						break;
					case 2:
						predictWinner();
						break;
					case 3:
						startGame();
						break;
					case 4:
						displayResults();
						break;
					case 5:
						displayPoints();
						break;
					}
				}
			/*} catch (Exception e) {

				System.out.println("you need input a valid option");
				String tempt = sc.nextLine();

			}*/
		//} while (choice != 6);

		
	}

	// Create menu for selecting game
	public void selectGame() {
		int choice1 = 0;
		//do {
			//try {
				System.out.println("1. Swimming");
				System.out.println("2. Cycling");
				System.out.println("3. Running");
				System.out.println(" ");
				System.out.println("Please choose:  ");
				choice1 = sc.nextInt();
				System.out.println(" ");

				if (choice1 > 3 || choice1 < 0) {
					System.out.println("Error Number!!! Please choose 1 to 3.");
					System.out.println("");
				} else {
					switch (choice1) {
					case 1:
						
						if(allGames.size()>0){
							if(allGames.get(allGames.size()-1).getTime()==0){
								allGames.remove(allGames.size()-1);
							}
						}
						
						ArrayList<Athlete> athletes = SportsPreparing.creatAthletes("Swimming");
						ArrayList<CompeteResult> competeform = SportsPreparing.prepareCompeteForm(athletes);
						allGames.add(SportsPreparing.creatSwimming(competeform));
						
						mainMenu();
						break;
					case 2:
						//
						break;
					case 3:
						//
						break;
					}
				}
			/*} catch (SQLException e) {
				System.out.println("you need input a valid option");
				String tempt = sc.nextLine();
			}*/
		//} while (choice1 != 1 || choice1 != 2 || choice1 != 3);
	}

	// Create a menu for predicting the winner
	public void predictWinner() {
		int athleteAmount = allGames.get(allGames.size()-1).getCompeteResults().size();
		for(int i = 1;i<=athleteAmount;i++){
			Athlete athlete = allGames.get(allGames.size()-1).getCompeteResults().get(i-1).getAthlete();
			System.out.println(i+"."+"ID: "+athlete.getID()+" | "+"Name: "+ athlete.getName()+" | "+"State: "+athlete.getState()+" | "+"Type: :"+athlete.getType());
		}
		System.out.println("Please make a prediction: ");
		int predictionNum = sc.nextInt();
		allGames.get(allGames.size()-1).setPredictedWinner(allGames.get(allGames.size()-1).getCompeteResults().get(predictionNum-1).getAthlete());
		mainMenu();
	}

	public void startGame() {
		ArrayList<CompeteResult> competeResults = SportsPreparing.presentCompeteResults(allGames.get(allGames.size()-1));
		Iterator<CompeteResult> iter = competeResults.iterator();
		CompeteResult competeResult;
		do{
			competeResult = iter.next();
			System.out.println("Time: "+competeResult.getTime()+" | ID: "+competeResult.getAthlete().getID()+" | Name: "+competeResult.getAthlete().getName()+" | Type: "+competeResult.getAthlete().getType());
		}while(iter.hasNext());
		System.out.println("Your prediction winner is: ");
		System.out.println("ID: "+allGames.get(allGames.size()-1).getPredictedWinner().getID()+" | Name :"+allGames.get(allGames.size()-1).getPredictedWinner().getName());
		if(competeResults.get(0).getAthlete().getID().equals(allGames.get(allGames.size()-1).getPredictedWinner().getID())){
			System.out.println("Congratulations!!!");
		}
		String backward;
		do{
			System.out.println();
			System.out.println("opertating option: ");
			System.out.println("1.Back to main menu  ");
			System.out.println();
			backward = sc.next();
			if(backward.equals("1")){
				mainMenu();
			}else{
				System.out.println("Please choose valid option");
			}
			
		
		}while(!backward.equals("1"));
	}

	public void displayResults() {
		// displayResults();
	}

	public void displayPoints() {
		// displayPoints();
	}

}