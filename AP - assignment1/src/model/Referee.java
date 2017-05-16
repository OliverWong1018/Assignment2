package model;
//Author is WEN ZHANG
//This class is for referee which extends from Participant.class.
public class Referee extends Participant{
	private String type;
	public Referee(String ID, String name, String age, String state, String type) {
		super(ID, name, age, state);
		this.type = type;
	}
	
}
