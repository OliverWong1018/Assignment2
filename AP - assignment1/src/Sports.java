
public abstract class Sports {
	private String sportsID;
	private Referee referee;
	private Athlete[] athletes;
	
	public Sports(String sportsID, Referee referee, Athlete[] athletes){
		this.setSportsID(sportsID);
		this.setReferee(referee);
		this.setAthletes(athletes);
	}

	public String getSportsID() {
		return sportsID;
	}

	public void setSportsID(String sportsID) {
		this.sportsID = sportsID;
	}

	public Referee getReferee() {
		return referee;
	}

	public void setReferee(Referee referee) {
		this.referee = referee;
	}

	public Athlete[] getAthletes() {
		return athletes;
	}

	public void setAthletes(Athlete[] athletes) {
		this.athletes = athletes;
	}
	public abstract int compete();
}
