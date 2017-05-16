//Author is JINZE WANG
//This table3 is display all results table.
package GUI;

import javafx.beans.property.SimpleStringProperty;

public class Table3 {
	private SimpleStringProperty rRank3;
	private SimpleStringProperty rID3;
	private SimpleStringProperty rName3;
	private SimpleStringProperty rTime3;
	private SimpleStringProperty rType3;
	private SimpleStringProperty rPoints3;

	public Table3(String rRank3, String rID3, String rName3, String rType3, String rTime3, String rPoints3) {
		this.rRank3 = new SimpleStringProperty(rRank3);
		this.rName3 = new SimpleStringProperty(rName3);
		this.rTime3 = new SimpleStringProperty(rTime3);
		this.rID3 = new SimpleStringProperty(rID3);
		this.rType3 = new SimpleStringProperty(rType3);
		this.rPoints3 = new SimpleStringProperty(rPoints3);

	}

	public String getRRank3() {
		return rRank3.get();
	}

	public void setRank3(String v) {
		rRank3.set(v);
	}

	public String getRName3() {
		return rName3.get();
	}

	public void setRName3(String v) {
		rName3.set(v);
	}

	public String getRTime3() {
		return rTime3.get();
	}

	public void setRTime3(String v) {
		rTime3.set(v);
	}

	public String getRID3() {
		return rID3.get();
	}

	public void setRID3(String v) {
		rID3.set(v);
	}

	public String getRType3() {
		return rType3.get();
	}

	public void setRType3(String v) {
		rType3.set(v);
	}

	public void setRpoints3(String v) {
		rPoints3.set(v);

	}

	public String getRPoints3() {
		return rPoints3.get();
	}
}
