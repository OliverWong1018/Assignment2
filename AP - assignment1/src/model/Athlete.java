package model;
//Author is Jinze Wang
//This class is for Athlete which extends from Participant.class, with the type for identifying different sports.
public class Athlete extends Participant{
	private int points = 0;
	private String type; 
	public Athlete(String ID, String name, String age, String state, String type) {
		super(ID, name, age, state);
		this.type = type;
	}
	public int getPoints() {
		return points;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	

}
