
public class CompeteResult {
	private int rank;
	private int time;
	private Athlete athlete;
	public CompeteResult(int rank, int time, Athlete athlete){
		this.rank = rank;
		this.time = time;
		this.athlete = athlete;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
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
}
