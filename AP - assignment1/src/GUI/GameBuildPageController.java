//Author is JINZE WANG
package GUI;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;
import io.DatabaseConn;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Athlete;
import model.CompeteResult;
import model.Cycling;
import model.Referee;
import model.Running;
import model.Sports;
import model.Swimming;

// Class for GameBUildPage Controller
public class GameBuildPageController implements Initializable {
	private Sports sport = null;
	private String sportID = null;
	private int gameTimes;
	private Referee referee = null;
	private ArrayList<CompeteResult> compResults = new ArrayList<CompeteResult>();
	private int althNeededNum;
	private int refNeededNum;
	@FXML
	TableView<Table> candidatesTable;
	@FXML
	TableColumn<Table, String> iID1;
	@FXML
	TableColumn<Table, String> iName1;
	@FXML
	TableColumn<Table, String> iAge1;
	@FXML
	TableColumn<Table, String> iState1;
	@FXML
	TableColumn<Table, String> iType1;

	@FXML
	TableView<Table2> participantsTable;
	@FXML
	TableColumn<Table2, String> iID2;
	@FXML
	TableColumn<Table2, String> iName2;
	@FXML
	TableColumn<Table2, String> iAge2;
	@FXML
	TableColumn<Table2, String> iState2;
	@FXML
	TableColumn<Table2, String> iType2;

	Button addAthletes;
	@FXML
	Button addReferees;
	@FXML
	Button addDelete;
	@FXML
	Button confirm;
	@FXML
	Label notice1;
	@FXML
	Label notice2;
	@FXML
	Label currentGameType;
	// index for candidatesTable
	private IntegerProperty index1 = new SimpleIntegerProperty();
	// index for ParticipantsTable
	private IntegerProperty index2 = new SimpleIntegerProperty();
	// data for candidatesTable
	final ObservableList<Table> data = FXCollections.observableArrayList();
	// data for ParticipantsTable
	final ObservableList<Table2> data2 = FXCollections.observableArrayList();
	private boolean indexInTab2 = false;
	private boolean indexInTab1 = true;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// set label of current game title
		GameBuildPage.setGameTitle(Main.currentGameType, currentGameType);
		// left table
		iID1.setCellValueFactory(new PropertyValueFactory<Table, String>("rID1"));
		iName1.setCellValueFactory(new PropertyValueFactory<Table, String>("rName1"));
		iAge1.setCellValueFactory(new PropertyValueFactory<Table, String>("rAge1"));
		iState1.setCellValueFactory(new PropertyValueFactory<Table, String>("rState1"));
		iType1.setCellValueFactory(new PropertyValueFactory<Table, String>("rType1"));
		ResultSet rs = DatabaseConn.getAllCandidates();
		GameBuildPage.setLeftTableValue(data, rs);
		candidatesTable.setItems(data);
		// right table
		iID2.setCellValueFactory(new PropertyValueFactory<Table2, String>("rID2"));
		iName2.setCellValueFactory(new PropertyValueFactory<Table2, String>("rName2"));
		iAge2.setCellValueFactory(new PropertyValueFactory<Table2, String>("rAge2"));
		iState2.setCellValueFactory(new PropertyValueFactory<Table2, String>("rState2"));
		iType2.setCellValueFactory(new PropertyValueFactory<Table2, String>("rType2"));
		// get the index when clicking on left table row
		candidatesTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
				index1.set(data.indexOf(newValue));
				// System.out.println("index1: "+index1.get());
			}
		});
		// get the index when clicking on right table row
		participantsTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
				index2.set(data2.indexOf(newValue));
				// System.out.println("index2: "+index2.get());
			}
		});
		candidatesTable.getSelectionModel().clearSelection();
	}

	public void detectIndexInTab1() {
		indexInTab2 = false;
		indexInTab1 = true;
	}

	public void detectIndexInTab2() {
		indexInTab2 = true;
		indexInTab1 = false;
	}

	public void delectAction(ActionEvent event) {
		// System.out.println("index1 Integer: "+index1.get());
		// System.out.println("index1: "+index1.get());
		// System.out.println("index2 Integer: "+index2.get());
		// System.out.println("index2: "+index2.get());
		// System.out.println(indexInTab2);
		if (indexInTab2 == true && data2.size() != 0 && index2.get() > -1) {
			int i = index2.get();
			if (i > -1) {
				data.add(new Table("", "", "", "", ""));
				int f = data.size() - 1;
				data.get(f).setRID1(data2.get(i).getRID2());
				data.get(f).setRName1(data2.get(i).getRName2());
				data.get(f).setRAge1(data2.get(i).getRAge2());
				data.get(f).setRState1(data2.get(i).getRState2());
				data.get(f).setRType1(data2.get(i).getRType2());
			}

			data2.remove(i);
			participantsTable.setItems(data2);
			candidatesTable.setItems(data);
			participantsTable.getSelectionModel().clearSelection();
			althNeededNum = GameBuildPage.getAlthNeededNum(althNeededNum, data2);
			refNeededNum = GameBuildPage.getRefNeededNum(refNeededNum, data2);
			notice2.setText("Delete successfully, " + althNeededNum + " althlete and " + refNeededNum
					+ " referee can be added maximum");
			notice1.setText("");
		} else {
			notice2.setText("You need to selet one target row in participant table to delete ");
			notice1.setText("");
		}
	}

	// button for add Athletes
	public void addAlthleteAction(ActionEvent event) {
		if (indexInTab1 == true) {
			althNeededNum = GameBuildPage.getAlthNeededNum(althNeededNum, data2);
			refNeededNum = GameBuildPage.getRefNeededNum(refNeededNum, data2);
			if (althNeededNum != 0) {
				int i = index1.get();
				notice1.setText("");
				if (i > -1) {
					if (data.get(i).getRType1().startsWith(Main.currentGameType)
							|| data.get(i).getRType1().equals("SuperAthlete")) {
						data2.add(new Table2("", "", "", "", ""));
						int f = data2.size() - 1;
						data2.get(f).setRID2(data.get(i).getRID1());
						data2.get(f).setRName2(data.get(i).getRName1());
						data2.get(f).setRAge2(data.get(i).getRAge1());
						data2.get(f).setRState2(data.get(i).getRState1());
						data2.get(f).setRType2(data.get(i).getRType1());
						participantsTable.setItems(data2);
						data.remove(i);
						candidatesTable.setItems(data);
						althNeededNum = GameBuildPage.getAlthNeededNum(althNeededNum, data2);
						refNeededNum = GameBuildPage.getRefNeededNum(refNeededNum, data2);
						notice1.setText("Adding Althlete successfully, " + althNeededNum + " althlete and "
								+ refNeededNum + " referee can be added maximum");
						notice2.setText("");
					} else {
						if (Main.currentGameType.equals("S"))
							notice1.setText(
									"Please choose Swimming or SuperAthlete type to add althletes in the current game");
						notice2.setText("");
						if (Main.currentGameType.equals("R"))
							notice1.setText(
									"Please choose Running or SuperAthlete type to add althletes in the current game");
						notice2.setText("");
						if (Main.currentGameType.equals("C"))
							notice1.setText(
									"Please choose Cycling or SuperAthlete type to add althletes in the current game");
						notice2.setText("");
					}
				}
			} else if (althNeededNum == 0 && refNeededNum != 0) {
				notice1.setText("Althletes are full, please select one referee for this game ");
				notice2.setText("");
			} else if (refNeededNum == 0 && althNeededNum == 0) {
				notice1.setText("All participants are ready, please click confirm button ");
				notice2.setText("");
			}
			candidatesTable.getSelectionModel().clearSelection();
		} else {
			notice1.setText("You need to selet one target row in candidate table to add participants ");
			notice2.setText("");
		}
	}

	// button for add referee
	public void addRefereeAction(ActionEvent event) {
		if (indexInTab1 == true) {
			althNeededNum = GameBuildPage.getAlthNeededNum(althNeededNum, data2);
			refNeededNum = GameBuildPage.getRefNeededNum(refNeededNum, data2);
			if (refNeededNum != 0) {
				int i = index1.get();
				notice1.setText("");
				if (i > -1) {
					if (data.get(i).getRType1().equals("Referee")) {
						data2.add(new Table2("", "", "", "", ""));
						int f = data2.size() - 1;
						data2.get(f).setRID2(data.get(i).getRID1());
						data2.get(f).setRName2(data.get(i).getRName1());
						data2.get(f).setRAge2(data.get(i).getRAge1());
						data2.get(f).setRState2(data.get(i).getRState1());
						data2.get(f).setRType2(data.get(i).getRType1());
						participantsTable.setItems(data2);
						data.remove(i);
						candidatesTable.setItems(data);
						althNeededNum = GameBuildPage.getAlthNeededNum(althNeededNum, data2);
						refNeededNum = GameBuildPage.getRefNeededNum(refNeededNum, data2);
						notice1.setText("Adding referee successfully, " + althNeededNum + " althlete and "
								+ refNeededNum + " referee can be added maximum");
						notice2.setText("");
					} else {
						notice1.setText("Please don't choose althlete type to add referee in the current game");
						notice2.setText("");
					}
				}
			} else if (refNeededNum == 0 && althNeededNum != 0) {
				notice1.setText("Referee is full, you can choose extra " + althNeededNum + " athlete for this game");
				notice2.setText("");
			} else if (refNeededNum == 0 && althNeededNum == 0) {
				notice1.setText("All participants are ready, please click confirm button ");
				notice2.setText("");
			}
			candidatesTable.getSelectionModel().clearSelection();
		} else {
			notice1.setText("You need to selet one target row in candidate table to add participants ");
			notice2.setText("");
		}
	}

	// button for confirm
	public void confirmAction() {
		int althNum = 0;
		int refNum = 0;
		for (int i = 0; i < data2.size(); i++) {
			if (!data2.get(i).getRType2().equals("Referee")) {
				althNum += 1;
			}
			if (data2.get(i).getRType2().equals("Referee")) {
				refNum += 1;
			}
		}
		if (refNum == 1 && althNum > 3 && althNum < 9) {
			for (int i = 0; i < data2.size(); i++) {
				if (data2.get(i).getRType2().equals("Referee")) {
					referee = new Referee(data2.get(i).getRID2(), data2.get(i).getRName2(), data2.get(i).getRAge2(),
							data2.get(i).getRState2(), data2.get(i).getRType2());
					data2.remove(i);
				}
			}
			for (int i = 0; i < data2.size(); i++) {
				compResults.add(new CompeteResult(new Athlete(data2.get(i).getRID2(), data2.get(i).getRName2(),
						data2.get(i).getRAge2(), data2.get(i).getRState2(), data2.get(i).getRType2())));
			}
			if (Main.currentGameType.equals("S")) {
				gameTimes = DatabaseConn.getGameTimes("swimming") + 1;

				if (gameTimes < 10) {
					sportID = "S0" + gameTimes;
				} else {
					sportID = "S" + gameTimes;
				}
				sport = new Swimming(sportID, referee, compResults);
			}
			if (Main.currentGameType.equals("R")) {
				gameTimes = DatabaseConn.getGameTimes("running") + 1;
				if (gameTimes < 10) {
					sportID = "R0" + gameTimes;
				} else {
					sportID = "R" + gameTimes;
				}
				sport = new Running(sportID, referee, compResults);
			}
			if (Main.currentGameType.equals("C")) {
				gameTimes = DatabaseConn.getGameTimes("cycling") + 1;
				if (gameTimes < 10) {
					sportID = "C0" + gameTimes;
				} else {
					sportID = "C" + gameTimes;
				}
				sport = new Cycling(sportID, referee, compResults);
			}
			Main.sport = this.sport;
			Stage stage = (Stage) confirm.getScene().getWindow();
			stage.close();

		} else if (refNum == 0 && althNum > 3 && althNum < 9) {
			notice2.setText("Please select one referee for this game ");
			notice1.setText("");
		} else if (refNum == 1 && althNum < 4) {
			int i = 4 - althNum;
			notice2.setText(
					"One game needs 4 althletes minimum, Please select " + i + " athletes at least for this game ");
			notice1.setText("");
		} else if (refNum == 0 && althNum < 4) {
			int i = 4 - althNum;
			notice2.setText("One game needs 4 althletes minimum and 1 referee, Please select " + i
					+ " athletes at and 1 referee least for this game ");
			notice1.setText("");
		}
	}
}