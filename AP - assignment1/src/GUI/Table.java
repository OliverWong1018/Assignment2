//Author is JINZE WANG
// This table is about Candidates Table.
package GUI;

import javafx.beans.property.SimpleStringProperty;

public class Table {
	private SimpleStringProperty rID1;
	private SimpleStringProperty rName1;
	private SimpleStringProperty rAge1;
	private SimpleStringProperty rState1;
	private SimpleStringProperty rType1;

	public Table(String rID1, String rName1, String rAge1, String rState1, String rType1) {
		this.rID1 = (new SimpleStringProperty(rID1));
		this.rName1 = new SimpleStringProperty(rName1);
		this.rAge1 = new SimpleStringProperty(rAge1);
		this.rState1 = new SimpleStringProperty(rState1);
		this.rType1 = new SimpleStringProperty(rType1);

	}

	public String getRID1() {
		return rID1.get();
	}

	public void setRID1(String v) {
		rID1.set(v);
	}

	public String getRName1() {
		return rName1.get();
	}

	public void setRName1(String v) {
		rName1.set(v);
	}

	public String getRAge1() {
		return rAge1.get();
	}

	public void setRAge1(String v) {
		rAge1.set(v);
	}

	public String getRState1() {
		return rState1.get();
	}

	public void setRState1(String v) {
		rState1.set(v);
	}

	public String getRType1() {
		return rType1.get();
	}

	public void setRType1(String v) {
		rType1.set(v);
	}

}
