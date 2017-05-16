package io;

import java.io.FileWriter;
import java.io.IOException;

public class AllResultsTXT {

	public static void UpdateGamesResults(String gameResult) {

		FileWriter writer = null;

		try {
			
			writer = new FileWriter("AllGamesResults.txt",true);
			
			writer.write(gameResult);
			

			writer.close();

		} catch (IOException e) {
			System.err.println("File cannot be created, or cannot be opened");
			System.exit(0);
		}
	}
	public static void clearAll(){
		FileWriter writer = null;

		try {
			
			writer = new FileWriter("AllGamesResults.txt");
			
			
			

			writer.close();

		} catch (IOException e) {
			System.err.println("File cannot be created, or cannot be opened");
			System.exit(0);
		}
	}
	/*public static void main(String[] args){
		clearAll();
		
	}*/
}
