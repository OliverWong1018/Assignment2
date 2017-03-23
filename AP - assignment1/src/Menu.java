import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	
	Scanner sc = new Scanner(System.in);
	do{
		int choice = 0;
		
			try{
				mainMenu();
				choice = sc.nextInt();
				System.out.println(" ");
				if (choice > 6 || choice < 0)
				{
					System.out.println("Error Number!!! Please choose 1 to 6.");
				}else
					{
					switch(choice){
					case 1:
						subMenu1();
						break;
					case 2:
						subMenu2();
						break;
					case 3:
						subMenu3();
						break;
					case 4:
						//get 比赛结果信息
						break;
					case 5:
						//get 运动员得分
						break;						
								  }
					}
			     }catch(InputMismatchException i)
			      {
			    	 
			      }
			
			
	}

		//print main menu of the game
		private void mainMenu(){
			System.out.println("Ozlympic Game");
			System.out.println("==================");
			System.out.println("1. Select a game to run");
			System.out.println("2. Predict the winner of the game");
			System.out.println("3. Start the game");
			System.out.println("4. Display the final results of all games");
			System.out.println("5. Display the points of all athletes");
			System.out.println("6. Exit");
			System.out.println("");
			System.out.println("Enter an option: ");
		}
		
	}


