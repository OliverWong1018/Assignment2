package model;
//Author is Jinze Wang
//This class is a superclass for Athlete and Referee.
public abstract class Participant {

	private String ID;
	private String name;
	private String age;
	private String state;

	public Participant(String ID, String name, String age2, String state){
		this.ID = ID;
		this.setName(name);
		this.setAge(age2);
		this.setState(state);
	}
	
	// get participant ID
	public String getID() {
		return ID;
	}
	//set participant ID
	public void setID(String ID) {
		this.ID = ID;
	}
	//get participant name
	public String getName() {
		return name;
	}
	//set participant name
	public void setName(String name) {
		this.name = name;
	}
	//get participant age
	public String getAge() {
		return age;
	}
	//set participant age
	public void setAge(String age2) {
		this.age = age2;
	}
	//get participant state
	public String getState() {
		return state;
	}
	//set participant state
	public void setState(String state) {
		this.state = state;
	}

	
}
	