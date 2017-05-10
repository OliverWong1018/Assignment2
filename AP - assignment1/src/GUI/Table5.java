package GUI;

import javafx.beans.property.SimpleStringProperty;

public class Table5 {
	private SimpleStringProperty rID5;
	private SimpleStringProperty rName5;
	private SimpleStringProperty rAge5;
	private SimpleStringProperty rState5;
	private SimpleStringProperty rType5;
	private SimpleStringProperty rPoints5;
	

	public Table5(String rID5, String rName5, String rAge5, String rState5, String rType5, String rPoints5) {
		this.rID5=(new SimpleStringProperty(rID5));
		this.rName5 = new SimpleStringProperty(rName5);
		this.rAge5 = new SimpleStringProperty(rAge5);
		this.rState5 = new SimpleStringProperty(rState5);
		this.rType5 = new SimpleStringProperty(rType5);
		this.rPoints5 = new SimpleStringProperty(rPoints5);


	}

	public String getRID5() {
		return rID5.get();
	}

	public void setRID5(String v) {
		rID5.set(v);
	}

	public String getRName5() {
		return rName5.get();
	}

	public void setRName5(String v) {
		rName5.set(v);
	}

	public String getRAge5() {
		return rAge5.get();
	}

	public void setRAge5(String v) {
		rAge5.set(v);
	}
	
	public String getRState5() {
		return rState5.get();
	}

	public void setRState5(String v) {
		rState5.set(v);
	}
	
	public String getRType5() {
		return rType5.get();
	}

	public void setRType5(String v) {
		rType5.set(v);
	}

	public String getRPoints5() {
		return rPoints5.get();
	}

	public void setRPoints5(String v) {
		rPoints5.set(v);
	}
}
