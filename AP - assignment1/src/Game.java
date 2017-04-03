import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;



public class Game {

	private Scanner sc = new Scanner(System.in);
	private ArrayList<Sports> allGames = new ArrayList<Sports>();
	private ArrayList<Athlete> allAthletes = new ArrayList<Athlete>();
	boolean flag = false;
	  //Generate a menu for Ozlymic Game
	 
	public Game(){
		setAllAthletes();
	}
	public void setAllAthletes() {
		allAthletes.addAll(SportsPreparing.creatAllAthletes());
	}

	public void begin() {
		String choice ;
		
		do {
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
				choice = sc.next();
				
				if(choice.equals("1")){
					flag = true;
					selectGame();
				}
				if(choice.equals("2")&flag)
					predictWinner();
				if(choice.equals("3")&flag)
					startGame();		
				if(choice.equals("4")&flag)
					displayResults();
				if(choice.equals("5")&flag)
					displayPoints();		
				if(choice.equals("6"))
					System.out.println("GameOver! See you next time!");		
				else
				System.out.println("Notice: Please choose valid option!!!");
						
				
		} while (!(choice.equals("1")||choice.equals("2")&flag||choice.equals("3")&flag||choice.equals("4")&flag||choice.equals("5")&flag||choice.equals("6")&flag));

		
	}

	// Create menu for selecting game
	public void selectGame() {
		String choice1 ;
		do {
			//try {
				System.out.println("1. Swimming");
				System.out.println("2. Cycling");
				System.out.println("3. Running");
				System.out.println(" ");
				System.out.println("Please choose:  ");
				choice1 = sc.next();
				if(allGames.size()>0){
					if(allGames.get(allGames.size()-1).getTime()==0){
						allGames.remove(allGames.size()-1);
					}
				}
				if(choice1.equals("1")){
					
					ArrayList<Athlete> athletes = SportsPreparing.creatAthletes("Swimming");
					ArrayList<CompeteResult> competeform = SportsPreparing.prepareCompeteForm(athletes);
					allGames.add(SportsPreparing.creatSwimming(competeform));
					
					begin();
				}
				if(choice1.equals("2")){
					
					
					ArrayList<Athlete> athletes2 = SportsPreparing.creatAthletes("Cycling");
					ArrayList<CompeteResult> competeform2 = SportsPreparing.prepareCompeteForm(athletes2);
					allGames.add(SportsPreparing.creatCycling(competeform2));
					
					begin();
				}	
				if(choice1.equals("3")){

					
					
					ArrayList<Athlete> athletes3 = SportsPreparing.creatAthletes("Running");
					ArrayList<CompeteResult> competeform3 = SportsPreparing.prepareCompeteForm(athletes3);
					allGames.add(SportsPreparing.creatRunning(competeform3));
					
					begin();	
				}else{
					System.out.println("Notice: Please choose valid option!!!");
				}
			}while(!(choice1.equals("1")||choice1.equals("2")||choice1.equals("3")));
	}
			

	// Create a menu for predicting the winner
	public void predictWinner() {
		int athleteAmount = allGames.get(allGames.size()-1).getCompeteResults().size();
		System.out.println("GameID: "+allGames.get(allGames.size()-1).getSportsID());
		System.out.println("Referee: "+allGames.get(allGames.size()-1).getReferee().getID()+" | "+allGames.get(allGames.size()-1).getReferee().getName());
		ArrayList<String> amount = new ArrayList<String>();
		for(int i = 1;i<=athleteAmount;i++){
			Athlete athlete = allGames.get(allGames.size()-1).getCompeteResults().get(i-1).getAthlete();
			System.out.println(i+"."+"ID: "+athlete.getID()+" | "+"Name: "+ athlete.getName()+" | "+"State: "+athlete.getState()+" | "+"Type: :"+athlete.getType());
			Integer inter = new Integer(i);
			amount.add(inter.toString());
		}
		String prediction;	
		int predictionNum= 0;
		do{
			 System.out.println("Please make a prediction: ");
			 prediction= sc.next();	
			 if(amount.contains(prediction)){
				 Integer inte = new Integer(prediction);
					predictionNum = inte.intValue();
					allGames.get(allGames.size()-1).setPredictedWinner(allGames.get(allGames.size()-1).getCompeteResults().get(predictionNum-1).getAthlete());
					begin();
			 }else{
				 System.out.println("Notice: Please choose valid option!!!");
			 }
		}while(!amount.contains(prediction));
		
	}

	public void startGame() {
		ArrayList<CompeteResult> competeResults = SportsPreparing.presentCompeteResults(allGames.get(allGames.size()-1));
		
		allAthletes = SportsPreparing.savePoints(allAthletes, competeResults);
		
		
		
		System.out.println("SportID: "+allGames.get(allGames.size()-1).getSportsID());
		Iterator<CompeteResult> iter = competeResults.iterator();
		CompeteResult competeResult;
		do{
			competeResult = iter.next();
			System.out.println("Rank: "+competeResult.getRank()+" | Time: "+competeResult.getTime()+" | ID: "+competeResult.getAthlete().getID()+" | Name: "+competeResult.getAthlete().getName()+" | Type: "+competeResult.getAthlete().getType());
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
				begin();
			}else{
				System.out.println("Please choose valid option");
			}
			
		
		}while(!backward.equals("1"));
	}

	public void displayResults() {
		Iterator<Sports> iterator = allGames.iterator();	 
		do{
			Sports sport = iterator.next();
			System.out.println("SportID: "+sport.getSportsID());
			System.out.println("Referee: "+sport.getReferee().getName());
			CompeteResult competeResult;
			Iterator<CompeteResult> iter = sport.getCompeteResults().iterator();
			do{
				competeResult = iter.next();
				System.out.println("Rank: "+competeResult.getRank()+" | Time: "+competeResult.getTime()+" | ID: "+competeResult.getAthlete().getID()+" | Name: "+competeResult.getAthlete().getName()+" | Type: "+competeResult.getAthlete().getType());				
			}while(iter.hasNext());
			System.out.println("Your prediction winner is: ");
			System.out.println("ID :"+sport.getPredictedWinner().getID()+" | Name: "+sport.getPredictedWinner().getName());
			System.out.println();
		}while(iterator.hasNext());
		
		String backward;
		do{
			System.out.println();
			System.out.println("opertating option: ");
			System.out.println("1.Back to main menu  ");
			System.out.println();
			backward = sc.next();
			if(backward.equals("1")){
				begin();
			}else{
				System.out.println("Please choose valid option");
			}
			
		
		}while(!backward.equals("1"));
	}

	public void displayPoints() {
		Athlete athletes;
		Iterator<Athlete> iter = allAthletes.iterator();
		do{
			athletes = iter.next();
			System.out.println("ID: "+athletes.getID()+" | Name: "+athletes.getName()+" | Points: "+athletes.getPoints()+" | Type: "+athletes.getType());				
		}while(iter.hasNext());
		
		String backward;
		do{
			System.out.println();
			System.out.println("opertating option: ");
			System.out.println("1.Back to main menu  ");
			System.out.println();
			backward = sc.next();
			if(backward.equals("1")){
				begin();
			}else{
				System.out.println("Please choose valid option");
			}
			
		
		}while(!backward.equals("1"));
	}

}