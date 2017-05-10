package GUI;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Table3Controller implements Initializable {

	@FXML
	TableView<Table3> currentResultsTable;
	@FXML
	TableColumn<Table3, String> iRank3;
	@FXML
	TableColumn<Table3, String> iName3;
	@FXML
	TableColumn<Table3, String> iTime3;
	@FXML
	TableColumn<Table3, String> iPoints3;

	@FXML
	public Button goBack;

	final ObservableList<Table3> data3 = FXCollections.observableArrayList(
			new Table3("1", "Wayne", "5.1", "5"),
			new Table3("2", "Oliver", "5.45", "4"), 
			new Table3("3", "Tim", "6.05", "3"));

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		iRank3.setCellValueFactory(new PropertyValueFactory<Table3, String>("rRank3"));
		iName3.setCellValueFactory(new PropertyValueFactory<Table3, String>("rName3"));
		iTime3.setCellValueFactory(new PropertyValueFactory<Table3, String>("rTime3"));
		iPoints3.setCellValueFactory(new PropertyValueFactory<Table3, String>("rPoints3"));

		currentResultsTable.setItems(data3);
	}

}
