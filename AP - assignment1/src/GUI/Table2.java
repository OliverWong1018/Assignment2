package GUI;

import javafx.beans.property.SimpleStringProperty;

public class Table2 {
	private SimpleStringProperty rType2;
	private SimpleStringProperty rName2;
	private SimpleStringProperty rAthleteType2;

	public Table2(String rType2, String rName2, String rAthleteType2) {
		this.rType2=(new SimpleStringProperty(rType2));
		this.rName2 = new SimpleStringProperty(rName2);
		this.rAthleteType2 = new SimpleStringProperty(rAthleteType2);

	}

	public String getRType2() {
		return rType2.get();
	}

	public void setRType2(String v) {
		rType2.set(v);
	}

	public String getRName2() {
		return rName2.get();
	}

	public void setRName2(String v) {
		rName2.set(v);
	}

	public String getRAthleteType2() {
		return rAthleteType2.get();
	}

	public void setRAthleteType2(String v) {
		rAthleteType2.set(v);
	}

}
