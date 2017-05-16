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
	public static String newResult =null;
	public static String getSportID(String currentGameType){
		int gameTimes = 0;
		String sportID = null; 
		if(currentGameType.equals("S")){
			gameTimes = DatabaseConn.getGameTimes("swimming");
		}
		if(currentGameType.equals("R")){
			gameTimes = DatabaseConn.getGameTimes("running");
		}
		if(currentGameType.equals("C")){
			gameTimes = DatabaseConn.getGameTimes("cycling");
		}
		if (gameTimes < 10) {
			sportID = currentGameType+"0" + gameTimes;
		} else {
			sportID = currentGameType + gameTimes;
		}
		return sportID;
	}
	public static ObservableList<Table3> setData3Values(ObservableList<Table3> data3,ArrayList<CompeteResult> gameResult){
		Iterator<CompeteResult> iter = gameResult.iterator();
		CompeteResult competeResult;
		int countRank = 1;
		do {
			competeResult = iter.next();
			data3.add(new Table3("","","","","",""));
		    int f = data3.size()-1;
		     data3.get(f).setRank3(Integer.toString(competeResult.getRank()));
		     data3.get(f).setRID3(competeResult.getAthlete().getID());
		     data3.get(f).setRName3(competeResult.getAthlete().getName());
		     data3.get(f).setRType3(competeResult.getAthlete().getType());
		     data3.get(f).setRTime3(Integer.toString(competeResult.getTime())+"s'");
		     if(countRank==1){
		    	 
		    	 data3.get(f).setRpoints3("5");
		     }
		     if(countRank==2){
		    	 data3.get(f).setRpoints3("2");
		     }
		     if(countRank==3){
		    	 data3.get(f).setRpoints3("1");
		     }
		     if(countRank>3){
		    	 data3.get(f).setRpoints3("0");
		     }
		     countRank++;	     
		} while (iter.hasNext());
		return data3;
	}
	public static void saveCurrResultToTXT(String sportID,ArrayList<CompeteResult> gameResult){
		Iterator<CompeteResult> iter = gameResult.iterator();
		CompeteResult competeResult;
		iter = gameResult.iterator();
		competeResultString = "";
		String titles = "Rank"+"  "+" ID  "+"  "+" Time "+"  "+"   Type   "+"  "+"  Name";
		
		for(int i =0;i<3;i++){
			competeResult = iter.next();
			
			competeResultString+= (Integer.toString(competeResult.getRank())+"   "+"||"+competeResult.getAthlete().getID()+"  "+"||"+Integer.toString(competeResult.getTime())
					+"   "+"||"+competeResult.getAthlete().getType()+"  "+"||"+competeResult.getAthlete().getName()+"\n");
		}
		newResult = sportID+"     "+Main.currentGameTime+"\n"+Main.sport.getReferee().getID()+"_"+Main.sport.getReferee().getName()
				+"\n"+titles+"\n"+competeResultString+"\n";
		AllResultsTXT.UpdateGamesResults(newResult);
	}
	public static void savePointsToDB(ArrayList<CompeteResult> gameResult){
		Iterator<CompeteResult> iter = gameResult.iterator();
		CompeteResult competeResult;
		iter = gameResult.iterator();
		do {
			 competeResult = iter.next();
		     if(competeResult.getRank()==1){      
		     DatabaseConn.updateAthletePoints(competeResult.getAthlete().getID(), 5);
		     }
		     if(competeResult.getRank()==2){      
			     DatabaseConn.updateAthletePoints(competeResult.getAthlete().getID(), 2);
			 }
		     if(competeResult.getRank()==3){      
			     DatabaseConn.updateAthletePoints(competeResult.getAthlete().getID(), 1);
			 }
		} while (iter.hasNext());
	}
	public static String getSystemTime(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(new Date());
	}
}
