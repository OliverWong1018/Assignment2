package GUI;

import javafx.beans.property.SimpleStringProperty;

public class Table {
	private SimpleStringProperty rType1;
	private SimpleStringProperty rName1;
	private SimpleStringProperty rAthleteType1;

	public Table(String rType1, String rName1, String rAthleteType1) {
		this.rType1=(new SimpleStringProperty(rType1));
		this.rName1 = new SimpleStringProperty(rName1);
		this.rAthleteType1 = new SimpleStringProperty(rAthleteType1);

	}

	public String getRType1() {
		return rType1.get();
	}

	public void setRType1(String v) {
		rType1.set(v);
	}

	public String getRName1() {
		return rName1.get();
	}

	public void setRName1(String v) {
		rName1.set(v);
	}

	public String getRAthleteType1() {
		return rAthleteType1.get();
	}

	public void setRAthleteType1(String v) {
		rAthleteType1.set(v);
	}

}
