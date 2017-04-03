//Author is Jinze Wang
//This class is for Athlete which extends from Participant.class, with the type for identifying different sports.
public class Athlete extends Participant{
	private int points = 0;
	private String type; 
	protected Athlete(String ID, String name, int age, String state, String type) {
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
	public void set5Points() {
		this.points +=5;
	}
	public void set2Points() {
		this.points +=2;
	}
	public void set1Points() {
		this.points +=1;
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
