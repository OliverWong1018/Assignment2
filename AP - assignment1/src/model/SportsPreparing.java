package model;
//Author name is Wen Zhang
import java.util.ArrayList;
import java.util.Iterator;
// This class is focus on supplying original data(Athletes and referee), and offer static method involving computing data for Game.class
public class SportsPreparing {
	
   //To compute the time and rank for each athlete and store in memory.
	public static ArrayList<CompeteResult> getCompeteResults(Sports sport) {
		Iterator<CompeteResult> iter = sport.getCompeteResults().iterator();
		do {
			iter.next().setTime(sport.computeTime());
		} while (iter.hasNext());

		sport.getCompeteResults().sort(new SortByTime());

		for (int i = 1; i <= sport.getCompeteResults().size(); i++) {
			sport.getCompeteResults().get(i - 1).setRank(i);
		}

		int temp = 1;
		do {

			if (sport.getCompeteResults().get(temp - 1).getTime() == sport.getCompeteResults().get(temp).getTime()) {

				sport.getCompeteResults().get(temp).setRank();

			}
			temp++;
		} while (temp < sport.getCompeteResults().size());

		return sport.getCompeteResults();

	}
 
	
}
