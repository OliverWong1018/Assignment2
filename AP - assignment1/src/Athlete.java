
public class Athlete extends Participant{
	private int points;
	private String type; 
	public Athlete(String ID, String name, int age, String state, String type) {
		super(ID, name, age, state);
		this.type = type;
	}
	/*
	 * get the game points
	 * @return
	 */
	public int getPoints() {
		return points;
	}
	/*
	 * set the game points
	 */
	public void setPoints(int points) {
		this.points = points;
	}
	/*
	 * get the type of the participants
	 * @return
	 */
	public String getType() {
		return type;
	}
	/*
	 * set the type of the participants
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	

}
