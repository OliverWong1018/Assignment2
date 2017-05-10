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
import model.CompeteResult;
import model.Referee;
import model.Sports;

public class TableController implements Initializable {
	
	public String s = "bbb";
	
	
	@FXML
	TableView<Table> candidatesTable;
	@FXML
	TableColumn<Table, String> iType1;
	@FXML
	TableColumn<Table, String> iName1;
	@FXML
	TableColumn<Table, String> iAthleteType1;

	@FXML
	TableView<Table2> participantsTable;
	@FXML
	TableColumn<Table2, String> iType2;
	@FXML
	TableColumn<Table2, String> iName2;
	@FXML
	TableColumn<Table2, String> iAthleteType2;

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
	final ObservableList<Table> data = FXCollections.observableArrayList();
	final ObservableList<Table2> data2 = FXCollections.observableArrayList();

	
	/*final ObservableList<Table> data = FXCollections.observableArrayList(new Table("Athlete", "Wayne", "Swimming"),
			new Table("Athlete", "Oliver", "Cycling"), new Table("Athlete", "Tim", "Running"),
			new Table("Referee", "Danny", "None"), new Table("Athlete", "Wayne", "Swimming"),
			new Table("Athlete", "Oliver", "Cycling"), new Table("Athlete", "Tim", "Running"),
			new Table("Referee", "Danny", "None"));

	final ObservableList<Table2> data2 = FXCollections.observableArrayList(new Table2("Athlete", "Wayne", "Swimming"),
			new Table2("Athlete", "Oliver", "Cycling"), new Table2("Athlete", "Tim", "Running"),
			new Table2("Referee", "Danny", "None"), new Table2("Athlete", "Wayne", "Swimming"),
			new Table2("Athlete", "Oliver", "Cycling"), new Table2("Athlete", "Tim", "Running"),
			new Table2("Referee", "Danny", "None"));
*/
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// left table
		iType1.setCellValueFactory(new PropertyValueFactory<Table, String>("rType1"));
		iName1.setCellValueFactory(new PropertyValueFactory<Table, String>("rName1"));
		iAthleteType1.setCellValueFactory(new PropertyValueFactory<Table, String>("rAthleteType1"));
		ResultSet rs = DatabaseConn.getAllCandidates();
		try{			
			while (rs.next()) {
				data.add(new Table("","",""));
				int f = data.size()-1;
					data.get(f).setRType1(rs.getString(1));
					data.get(f).setRName1(rs.getString(2));
					data.get(f).setRAthleteType1(rs.getString(3));
								
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		candidatesTable.setItems(data);

		// right table
		iType2.setCellValueFactory(new PropertyValueFactory<Table2, String>("rType2"));
		iName2.setCellValueFactory(new PropertyValueFactory<Table2, String>("rName2"));
		iAthleteType2.setCellValueFactory(new PropertyValueFactory<Table2, String>("rAthleteType2"));
		
		

		// get the index when clicking on left table row
		candidatesTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
				index1.set(data.indexOf(newValue));
				System.out.println("Index1 is:" + data.indexOf(newValue));
			}

		});

		// get the index when clicking on right table row
		participantsTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
				index2.set(data2.indexOf(newValue));
				System.out.println("Index2 is:" + data2.indexOf(newValue));
			}

		});

	}
	public void delectAction(ActionEvent event){
		int i = index2.get();
		if (i > -1){
			data2.remove(i);
		}
		participantsTable.getSelectionModel().clearSelection();
	}
	public void addAction(ActionEvent event){
		int i = index1.get();
		if (i > -1){
			data2.add(new Table2("","",""));
			int f = data2.size()-1;
				data2.get(f).setRType2(data.get(i).getRType1());
				data2.get(f).setRName2(data.get(i).getRName1());
				data2.get(f).setRAthleteType2(data.get(i).getRAthleteType1());
				participantsTable.setItems(data2);
		}
		candidatesTable.getSelectionModel().clearSelection();
	}
	public void confirmAction(){	
		Main.s ="table";
		Stage stage = (Stage)confirm.getScene().getWindow();
	    stage.close();
	}
}
