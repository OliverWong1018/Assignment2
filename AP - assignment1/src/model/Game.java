package model;
//Author name is Jinze Wang
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javafx.fxml.FXML;

//The class is driver class where user interaction occurs,  utilizing other classes to manage the games.
public class Game {

	private Scanner sc = new Scanner(System.in);
	private ArrayList<Sports> allGames = new ArrayList<Sports>();
	private ArrayList<Athlete> allAthletes = new ArrayList<Athlete>();
	boolean flag = false;
	boolean flag2 = true;

	public Game() {
		setAllAthletes();
	}
//Input all athletes data to ArrayList<Athlete> allAthletes to prepare to get scores. 
	public void setAllAthletes() {
		//this.allAthletes.addAll(SportsPreparing.creatAllAthletes());
	}
//To present Menu and to deal with different options from users.
	public void begin() {
		String choice;

		do {
			Menu.mainMenu();

			choice = sc.next();

			if (choice.equals("1")) {
				flag = true;
				flag2 = true;
				selectGame();

			}
			if (choice.equals("2") & flag & flag2) {

			
			}
			if (choice.equals("3") & flag & flag2) {
				flag2 = false;
				startGame();

			}
			if (choice.equals("4") & flag) {

				displayResults();
			}
			if (choice.equals("5") & flag) {

				displayPoints();
			}
			if (choice.equals("6"))
				System.out.println("GameOver! See you next time!");
			else

			if (choice.equals("2") & !flag || choice.equals("3") & !flag || choice.equals("4") & !flag
					|| choice.equals("5") & !flag) {
				System.out.println("Please select a game to run firstly!!!");
			} else if (choice.equals("2") & !flag2 || choice.equals("3") & !flag2) {
				System.out.println("this game is over, please select a new game to run");
			} else {
				System.out.println("Notice: Please choose valid option!!!");
			}
		} while (!(choice.equals("1") || choice.equals("2") & flag & flag2 || choice.equals("3") & flag & flag2
				|| choice.equals("4") & flag || choice.equals("5") & flag || choice.equals("6")));

	}

//Select a game to run

	public void selectGame() {
		String choice1;
		do {
			Menu.secondMenu();

			choice1 = sc.next();
			if (allGames.size() > 0) {
				if (allGames.get(allGames.size() - 1).computeTime() == 0) {
					allGames.remove(allGames.size() - 1);
				}
			}
			if (choice1.equals("1")) {

				SportsPreparing.runGame("Swimming", allGames);
				begin();
			}
			if (choice1.equals("2")) {

				SportsPreparing.runGame("Cycling", allGames);
				begin();
			}
			if (choice1.equals("3")) {

				SportsPreparing.runGame("Running", allGames);
				begin();
			} else {
				System.out.println("Notice: Please choose valid option!!!");
			}
		} while (!(choice1.equals("1") || choice1.equals("2") || choice1.equals("3")));
	}

// To allow user make a predicting for the winner for the current game.
	
//To start the current game and award points to top 3 athletes according to their ranks. If the prediction is right, presenting a message to the user
	public void startGame() {
		ArrayList<CompeteResult> competeResults = SportsPreparing
				.getCompeteResults(allGames.get(allGames.size() - 1));

		allAthletes = SportsPreparing.savePoints(allAthletes, competeResults);

		System.out.println("SportID: " + allGames.get(allGames.size() - 1).getSportsID());
		Iterator<CompeteResult> iter = competeResults.iterator();
		CompeteResult competeResult;
		do {
			competeResult = iter.next();
			System.out.println("Rank: " + competeResult.getRank() + " | Time: " + competeResult.getTime() + " | ID: "
					+ competeResult.getAthlete().getID() + " | Name: " + competeResult.getAthlete().getName()
					+ " | Type: " + competeResult.getAthlete().getType());
		} while (iter.hasNext());
		


		String backward;
		do {
			Menu.backward();

			backward = sc.next();
			if (backward.equals("1")) {
				begin();
			} else {
				System.out.println("Please choose valid option");
			}

		} while (!backward.equals("1"));
	}
//To display the final result of all games including the name of the referee for each game.
	public void displayResults() {
		Iterator<Sports> iterator = allGames.iterator();
		do {
			Sports sport = iterator.next();
			System.out.println("SportID: " + sport.getSportsID());
			System.out.println("Referee: " + sport.getReferee().getName());
			CompeteResult competeResult;
			Iterator<CompeteResult> iter = sport.getCompeteResults().iterator();
			do {
				competeResult = iter.next();
				System.out.println("Rank: " + competeResult.getRank() + " | Time: " + competeResult.getTime()
						+ " | ID: " + competeResult.getAthlete().getID() + " | Name: "
						+ competeResult.getAthlete().getName() + " | Type: " + competeResult.getAthlete().getType());
			} while (iter.hasNext());
			
		} while (iterator.hasNext());

		String backward;
		do {
			Menu.backward();
			backward = sc.next();
			if (backward.equals("1")) {
				begin();
			} else {
				System.out.println("Please choose valid option");
			}

		} while (!backward.equals("1"));
	}
//TO display the points of all the athletes in store.
	public void displayPoints() {
		Athlete athletes;
		Iterator<Athlete> iter = allAthletes.iterator();
		do {
			athletes = iter.next();
			System.out.println("ID: " + athletes.getID() + " | Name: " + athletes.getName() + " | Points: "
					+ athletes.getPoints() + " | Type: " + athletes.getType());
		} while (iter.hasNext());

		String backward;
		do {
			Menu.backward();
			backward = sc.next();
			if (backward.equals("1")) {
				begin();
			} else {
				System.out.println("Please choose valid option");
			}

		} while (!backward.equals("1"));
	}

}