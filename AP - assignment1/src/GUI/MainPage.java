// Author is JINZE WANG
package GUI;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import io.AllResultsTXT;
import io.DatabaseConn;
import javafx.collections.ObservableList;
import model.CompeteResult;

public class MainPage {
	public static String competeResultString = null;
	public static String newResult = null;
	public static int AmountGetPoint =0;
	public static String getSportID(String currentGameType) {
		int gameTimes = 0;
		String sportID = null;
		if (currentGameType.equals("S")) {
			gameTimes = DatabaseConn.getGameTimes("swimming");
		}
		if (currentGameType.equals("R")) {
			gameTimes = DatabaseConn.getGameTimes("running");
		}
		if (currentGameType.equals("C")) {
			gameTimes = DatabaseConn.getGameTimes("cycling");
		}
		if (gameTimes < 10) {
			sportID = currentGameType + "0" + gameTimes;
		} else {
			sportID = currentGameType + gameTimes;
		}
		return sportID;
	}

	// insert data to current result Table
	public static ObservableList<Table3> setData3Values(ObservableList<Table3> data3,
			ArrayList<CompeteResult> gameResult) {
		Iterator<CompeteResult> iter = gameResult.iterator();
		CompeteResult competeResult;
		do {
			competeResult = iter.next();
			data3.add(new Table3("", "", "", "", "", ""));
			int f = data3.size() - 1;
			data3.get(f).setRank3(Integer.toString(competeResult.getRank()));
			data3.get(f).setRID3(competeResult.getAthlete().getID());
			data3.get(f).setRName3(competeResult.getAthlete().getName());
			data3.get(f).setRType3(competeResult.getAthlete().getType());
			data3.get(f).setRTime3(Integer.toString(competeResult.getTime()) + "s'");
			if (competeResult.getRank() == 1) {

				data3.get(f).setRpoints3("5");
			}
			if (competeResult.getRank() == 2) {
				data3.get(f).setRpoints3("2");
			}
			if (competeResult.getRank() == 3) {
				data3.get(f).setRpoints3("1");
			}
			if (competeResult.getRank() > 3) {
				data3.get(f).setRpoints3("0");
			}
			
		} while (iter.hasNext());
		return data3;
	}
	
	// Save current results to files.
	public static void saveCurrResultToTXT(String sportID, ArrayList<CompeteResult> gameResult) {
		Iterator<CompeteResult> iter = gameResult.iterator();
		CompeteResult competeResult;
		//iter = gameResult.iterator();
		competeResultString = "";
		String titles = "Rank" + "  " + " ID  " + "  " + " Time " + "  " + " Points   " + "  " + "  Name";
		int points = 0;
		for (int i = 0; i < AmountGetPoint; i++) {
			competeResult = iter.next();
			if(competeResult.getRank()==1)
				points=5;
			if(competeResult.getRank()==2)
				points=2;
			if(competeResult.getRank()==3)
				points=1;
			competeResultString += (Integer.toString(competeResult.getRank()) + "   " + "||"
					+ competeResult.getAthlete().getID() + "  " + "||" + Integer.toString(competeResult.getTime())
					+ "   " + "||   " + points + "  " + "   ||    "
					+ competeResult.getAthlete().getName() + "\n");
		}
		newResult = sportID + "     " + Main.currentGameTime + "\n" + Main.sport.getReferee().getID() + "_"
				+ Main.sport.getReferee().getName() + "\n" + titles + "\n" + competeResultString + "\n";
		AllResultsTXT.UpdateGamesResults(newResult);
	}

	// save points into database
	public static void savePointsToDB(ArrayList<CompeteResult> gameResult) {
		AmountGetPoint=0;
		Iterator<CompeteResult> iter = gameResult.iterator();
		CompeteResult competeResult;
		iter = gameResult.iterator();
		do {
			competeResult = iter.next();
			if (competeResult.getRank() == 1) {
				DatabaseConn.updateAthletePoints(competeResult.getAthlete().getID(), 5);
				AmountGetPoint++;
			}
			if (competeResult.getRank() == 2) {
				DatabaseConn.updateAthletePoints(competeResult.getAthlete().getID(), 2);
				AmountGetPoint++;
			}
			if (competeResult.getRank() == 3) {
				DatabaseConn.updateAthletePoints(competeResult.getAthlete().getID(), 1);
				AmountGetPoint++;
			}
		} while (iter.hasNext());
	}

	public static String getSystemTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(new Date());
	}
}
