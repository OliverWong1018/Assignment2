import java.util.ArrayList;

public abstract class Sports {
	private String sportsID;
	private Referee referee;
	private ArrayList<Athlete> athletes;
	private ArrayList<CompeteResult> competeResults;
	
	public Sports(String sportsID, Referee referee, ArrayList<Athlete> athletes){
		this.setSportsID(sportsID);
		this.setReferee(referee);
		this.setAthletes(athletes);
	}
	
	/*
	 * get unique ID for each game.
	 * @return
	 */
	public String getSportsID() {
		return sportsID;
	}
	
	/*
	 * set unique ID for each game
	 */
	public void setSportsID(String sportsID) {
		this.sportsID = sportsID;
	}
	
	/*
	 * get referee for each game
	 * @return
	 */
	public Referee getReferee() {
		return referee;
	}
	
	/*
	 * set referee for each game
	 */
	public void setReferee(Referee referee) {
		this.referee = referee;
	}

	// get athletes for each game
	public ArrayList<Athlete> getAthletes() {
		return athletes;
	}
	
	
	
	// set athlete for each game
	public void setAthletes(ArrayList<Athlete> athletes){
		this.athletes = athletes;
	}	
	
	

	public ArrayList<CompeteResult> getCompeteResults() {
		return competeResults;
	}


	public abstract int getTime();
	
	public  ArrayList<CompeteResult> setCompeteResults(){	
		int time = this.getTime();
		
		return null;
		
	}
}
