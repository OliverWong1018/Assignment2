
public class Athlete extends Participant{
	private int points;
	private String type; 
	public Athlete(String ID, String name, int age, String state, String type) {
		super(ID, name, age, state);
		this.type = type;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	

}
