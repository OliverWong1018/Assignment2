
public class CompeteResult {
	
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
}
