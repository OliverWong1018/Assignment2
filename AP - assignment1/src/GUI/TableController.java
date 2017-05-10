package GUI;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
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
import javafx.scene.Node;
import javafx.scene.control.Button;
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

public class TableController implements Initializable {
	private Sports sport = null;
	private Referee referee = null;
	private ArrayList<CompeteResult> compResults = null;
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
	public Button confirm;

	// index for candidatesTable
	private IntegerProperty index1 = new SimpleIntegerProperty();
	// index for ParticipantsTable
	private IntegerProperty index2 = new SimpleIntegerProperty();
	// data for candidatesTable
	final ObservableList<Table> data = FXCollections.observableArrayList();
	// data for ParticipantsTable
	final ObservableList<Table2> data2 = FXCollections.observableArrayList();

	/*
	 * final ObservableList<Table> data = FXCollections.observableArrayList(new
	 * Table("Athlete", "Wayne", "Swimming"), new Table("Athlete", "Oliver",
	 * "Cycling"), new Table("Athlete", "Tim", "Running"), new Table("Referee",
	 * "Danny", "None"), new Table("Athlete", "Wayne", "Swimming"), new
	 * Table("Athlete", "Oliver", "Cycling"), new Table("Athlete", "Tim",
	 * "Running"), new Table("Referee", "Danny", "None"));
	 * 
	 * final ObservableList<Table2> data2 =
	 * FXCollections.observableArrayList(new Table2("Athlete", "Wayne",
	 * "Swimming"), new Table2("Athlete", "Oliver", "Cycling"), new
	 * Table2("Athlete", "Tim", "Running"), new Table2("Referee", "Danny",
	 * "None"), new Table2("Athlete", "Wayne", "Swimming"), new
	 * Table2("Athlete", "Oliver", "Cycling"), new Table2("Athlete", "Tim",
	 * "Running"), new Table2("Referee", "Danny", "None"));
	 */
	@Override
	 public void initialize(URL location, ResourceBundle resources) {
	  // left table
	  iID1.setCellValueFactory(new PropertyValueFactory<Table, String>("rID1"));
	  iName1.setCellValueFactory(new PropertyValueFactory<Table, String>("rName1"));
	  iAge1.setCellValueFactory(new PropertyValueFactory<Table, String>("rAge1"));
	  iState1.setCellValueFactory(new PropertyValueFactory<Table, String>("rState1"));
	  iType1.setCellValueFactory(new PropertyValueFactory<Table, String>("rType1"));
	  ResultSet rs = DatabaseConn.getAllCandidates();
	  try{   
	   while (rs.next()) {
	    data.add(new Table("","","","",""));
	    int f = data.size()-1;
	     data.get(f).setRID1(rs.getString(1));
	     data.get(f).setRName1(rs.getString(2));
	     data.get(f).setRAge1(rs.getString(4));
	     data.get(f).setRState1(rs.getString(5));
	     data.get(f).setRType1(rs.getString(3));
	        
	   }
	  }catch (SQLException e) {
	   e.printStackTrace();
	  }
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
	    //System.out.println("Index1 is:" + data.indexOf(newValue));
	   }

	  });

	  // get the index when clicking on right table row
	  participantsTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {

	   @Override
	   public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
	    index2.set(data2.indexOf(newValue));
	    //System.out.println("Index2 is:" + data2.indexOf(newValue));
	   }

	  });

	 }

	public void delectAction(ActionEvent event) {
		int i = index2.get();
		if (i > -1) {
			data2.remove(i);
		}
		participantsTable.getSelectionModel().clearSelection();
	}

	public void addAction(ActionEvent event) {
		int i = index1.get();
		if (i > -1) {
			data2.add(new Table2("", "", "","",""));
			int f = data2.size() - 1;
			data2.get(f).setRID2(data.get(i).getRID1());
			data2.get(f).setRName2(data.get(i).getRName1());
			data2.get(f).setRAge2(data.get(i).getRAge1());
			data2.get(f).setRState2(data.get(i).getRState1());
			data2.get(f).setRType2(data.get(i).getRType1());
			participantsTable.setItems(data2);
		}
		candidatesTable.getSelectionModel().clearSelection();
	}

	public void confirmAction() {
		for (int i = 0; i < data2.size(); i++) {
			if(data2.get(i).getRType2().equals("Referee")){
				referee = new Referee(data2.get(i).getRID2(), data2.get(i).getRName2(), data2.get(i).getRAge2(), data2.get(i).getRState2(),data2.get(i).getRType2());
				data2.remove(i);
			}
		}
		for (int i = 0; i < data2.size(); i++) {
			compResults.add(new CompeteResult(new Athlete(data2.get(i).getRID2(), data2.get(i).getRName2(), data2.get(i).getRAge2(), data2.get(i).getRState2(),data2.get(i).getRType2())));	
		}
		if(Main.currentGameType.equals("s")){
		    sport = new Swimming(null, referee, compResults);
		}
		if(Main.currentGameType.equals("r")){
			sport = new Running(null, referee, compResults);
		}
		if(Main.currentGameType.equals("s")){
			sport = new Cycling(null, referee, compResults);
		}
		Main.sport = this.sport;
		Stage stage = (Stage) confirm.getScene().getWindow();
		stage.close();
	}
}