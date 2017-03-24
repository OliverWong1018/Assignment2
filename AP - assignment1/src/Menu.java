import java.util.Scanner;

public class Menu
{
	Scanner sc = new Scanner(System.in);
	public void mainMenu(){
		int choice = 0;
		
		do{
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
		}while(choice != 6);
		System.out.println("Thank you");
	}
		
	
	public void subMenu1()
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
					//
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
		
		
	public void subMenu2()
		{
			//game.althlete.getName();
		}
		
	public void subMenu3()
		{
			// run game
		}
	public void subMenu4()
		{
		//displayResults();
		}
	public void subMenu5()
		{
		//displayPoints();
		}
	
	}