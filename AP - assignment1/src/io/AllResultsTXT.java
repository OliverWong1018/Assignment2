//Author's name is Wen Zhang 
package io;

import java.io.FileWriter;
import java.io.IOException;
//this Class is for Write all games results to AllGamesResults.txt
public class AllResultsTXT {
	//add new game result into AllGamesResults.txt
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
	//clear all content of AllGamesResults.txt 
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
