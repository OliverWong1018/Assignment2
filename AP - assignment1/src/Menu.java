import java.util.ArrayList;
import java.util.Scanner;

public class Menu{
	
	
	
	Scanner sc = new Scanner(System.in);
	/*
	 * Generate a menu for Ozlymic Game
	 */
	public void mainMenu(){
		int choice=0;
		
		do{
			try{
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
			
			if (choice > 6 || choice < 0)
				{
					System.out.println("Error Number!!! Please choose 1 to 6.");
			}else
				{
				switch(choice){
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
			}
		catch(Exception e){
			
			System.out.println("you need input a valid option");
			String tempt = sc.nextLine();
			
		}}while(choice!=6);
	
		System.out.println("Game over");
	}
		
	// Create menu for selecting game
	public void selectGame()
		{
			int choice1 = 0;
		 do{
			System.out.println("1. Swimming");
			System.out.println("2. Cycling");
			System.out.println("3. Running");
			System.out.println(" ");
			System.out.println("Please choose:  ");
			choice1 = sc.nextInt();
			System.out.println(" ");
			
			if(choice1 >3 || choice1<0)
			{
				System.out.println("Error Number!!! Please choose 1 to 3.");
				System.out.println("");
			}else 
				{
				switch (choice1){
				case 1:
					ArrayList<Athlete> athletes = SportsPreparing.creatAthletes("Swimming");
					ArrayList<CompeteResult> competeform = SportsPreparing.prepareCompeteForm(athletes);
					Swimming swimming = SportsPreparing.creatSwimming(competeform);
					System.out.println("1111");
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
			}while (choice1 != 1 || choice1 != 2 || choice1 != 3);
		}
		
	// Create a menu for predicting the winner	
	public void predictWinner()
		{
			//game.althlete.getName();
		}
	
	
	
	
	public void startGame()
		{
			// run game
		}
	public void displayResults()
		{
		//displayResults();
		}
	public void displayPoints()
		{
		//displayPoints();
		}
	
	}