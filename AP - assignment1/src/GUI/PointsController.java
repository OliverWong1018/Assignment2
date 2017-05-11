package GUI;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import io.DatabaseConn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class PointsController implements Initializable{
	
	@FXML
	public Button closeButton;
	
	@FXML
	TableView<Table5> allPointsTable;
	@FXML
	TableColumn<Table5, String> iID5;
	@FXML
	TableColumn<Table5, String> iName5;
	@FXML
	TableColumn<Table5, String> iAge5;
	@FXML
	TableColumn<Table5, String> iState5;
	@FXML
	TableColumn<Table5, String> iType5;
	@FXML
	TableColumn<Table5, String> iPoints5;
	
	@FXML
	private void goBack(ActionEvent event){
		Stage stage = (Stage) closeButton.getScene().getWindow();
	    stage.close();
	}
	final ObservableList<Table5> data5 = FXCollections.observableArrayList();
	/*
	final ObservableList<Table5> data5 = FXCollections.observableArrayList(
			new Table5("R01", "Wayne", "20", "Vic","Referee","None"),
			new Table5("A01", "Oliver", "23", "Nsw","Swimmer","5"), 
			new Table5("A02", "Tim", "30", "Tas","Runner","3"));
	*/
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		iID5.setCellValueFactory(new PropertyValueFactory<Table5, String>("rID5"));
		iName5.setCellValueFactory(new PropertyValueFactory<Table5, String>("rName5"));
		iAge5.setCellValueFactory(new PropertyValueFactory<Table5, String>("rAge5"));
		iState5.setCellValueFactory(new PropertyValueFactory<Table5, String>("rState5"));
		iType5.setCellValueFactory(new PropertyValueFactory<Table5, String>("rType5"));
		iPoints5.setCellValueFactory(new PropertyValueFactory<Table5, String>("rPoints5"));
		
		 ResultSet rs = DatabaseConn.getPoints();
		  try{   
		   while (rs.next()) {
		    data5.add(new Table5("","","","","", ""));
		    int f = data5.size()-1;
		     data5.get(f).setRID5(rs.getString(1));
		     data5.get(f).setRName5(rs.getString(2));
		     data5.get(f).setRAge5(rs.getString(4));
		     data5.get(f).setRState5(rs.getString(5));
		     data5.get(f).setRType5(rs.getString(3));
		     data5.get(f).setRPoints5(rs.getString(6));
		   }
		  }catch (SQLException e) {
		   e.printStackTrace();
		  }
		allPointsTable.setItems(data5);
	}
	
}
