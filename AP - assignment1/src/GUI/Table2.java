//Author is WEN ZHANG
//This table is about participants table.
package GUI;

import javafx.beans.property.SimpleStringProperty;

public class Table2 {
	private SimpleStringProperty rID2;
	private SimpleStringProperty rName2;
	private SimpleStringProperty rAge2;
	private SimpleStringProperty rState2;
	private SimpleStringProperty rType2;

	public Table2(String rID2, String rName2, String rAge2, String rState2, String rType2) {
		this.rID2 = (new SimpleStringProperty(rID2));
		this.rName2 = new SimpleStringProperty(rName2);
		this.rAge2 = new SimpleStringProperty(rAge2);
		this.rState2 = new SimpleStringProperty(rState2);
		this.rType2 = new SimpleStringProperty(rType2);

	}

	public String getRID2() {
		return rID2.get();
	}

	public void setRID2(String v) {
		rID2.set(v);
	}

	public String getRName2() {
		return rName2.get();
	}

	public void setRName2(String v) {
		rName2.set(v);
	}

	public String getRAge2() {
		return rAge2.get();
	}

	public void setRAge2(String v) {
		rAge2.set(v);
	}

	public String getRState2() {
		return rState2.get();
	}

	public void setRState2(String v) {
		rState2.set(v);
	}

	public String getRType2() {
		return rType2.get();
	}

	public void setRType2(String v) {
		rType2.set(v);
	}

}
