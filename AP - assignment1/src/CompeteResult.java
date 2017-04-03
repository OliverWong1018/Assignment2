//Author is Wen Zhang
//A class for compete result fo each game.
public class CompeteResult {
	private int rank;
	private int time;
	private Athlete athlete;
	public CompeteResult(Athlete athlete){
		
		this.time = 0;
		this.athlete = athlete;
	}
	
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public Athlete getAthlete() {
		return athlete;
	}
	public void setAthlete(Athlete athlete) {
		this.athlete = athlete;
	}

	public int getRank() {
		return rank;
	}

	public void setRank() {
		this.rank -=1;
	}
	public void setRank(int rank) {
		this.rank =rank;
	}
}
