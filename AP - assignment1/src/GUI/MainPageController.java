//Author is WENZHANG
//Class for control MainPage action
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import io.DatabaseConn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.CompeteResult;
import model.SportsProcessing;

public class MainPageController implements Initializable {
	public ArrayList<CompeteResult> gameResult = new ArrayList<CompeteResult>();
	String sportID = null;
	final ObservableList<Table3> data3 = FXCollections.observableArrayList();
	String titles = null;
	@FXML
	public Button btn;
	@FXML
	public ProgressBar pgb;
	@FXML
	public Label gameID;
	@FXML
	public Label notice;
	@FXML
	public ProgressIndicator pgi;
	@FXML
	public Label referee;
	@FXML
	TableView<Table3> currentResultsTable;
	@FXML
	TableColumn<Table3, String> iRank3;
	@FXML
	TableColumn<Table3, String> iID3;
	@FXML
	TableColumn<Table3, String> iName3;
	@FXML
	TableColumn<Table3, String> iTime3;
	@FXML
	TableColumn<Table3, String> iType3;
	@FXML
	TableColumn<Table3, String> iPoints3;

	@FXML
	private void goResult() throws IOException {
		Main.displayResult();
	}

	@FXML
	private void gameOver() throws IOException {
		Main.closeWindow();
	}

	@FXML
	private void selectAGame() throws IOException {
		Main.selectGamePage();
		this.currentResultsTable.getItems().clear();
		this.btn.setText("Let's beign");
		this.notice.setText("");
	}

	@FXML
	private void goPoints() throws IOException {
		Main.displayPoints();
	}

	private ExecutorService svc = Executors.newSingleThreadExecutor();

	protected ExecutorService getService() {
		return svc;
	}

	// insert data to current result table.
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		assert btn != null : "fx:id=\"btn\" was not injected: check your FXML file 'Progress.fxml'.";
		assert pgb != null : "fx:id=\"pgb\" was not injected: check your FXML file 'Progress.fxml'.";
		assert pgi != null : "fx:id=\"pgi\" was not injected: check your FXML file 'Progress.fxml'.";
		// TODO Auto-generated method stub
		iRank3.setCellValueFactory(new PropertyValueFactory<Table3, String>("rRank3"));
		iName3.setCellValueFactory(new PropertyValueFactory<Table3, String>("rName3"));
		iTime3.setCellValueFactory(new PropertyValueFactory<Table3, String>("rTime3"));
		iID3.setCellValueFactory(new PropertyValueFactory<Table3, String>("rID3"));
		iType3.setCellValueFactory(new PropertyValueFactory<Table3, String>("rType3"));
		iPoints3.setCellValueFactory(new PropertyValueFactory<Table3, String>("rPoints3"));
	}

	// play game button.
	@FXML
	public void btnOnAction(ActionEvent e) {
		if (Main.sport != null) {
			// process bar
			Task<Void> task = new Task<Void>() {
				@Override
				public Void call() throws Exception {
					int time = 1; // sec
					int loopCount = 1000;
					btn.setDisable(true);
					int sleepMSec = time * 1000 / loopCount;

					for (int i = 0; i < loopCount; i++) {
						if (isCancelled()) {
							break;
						}
						Thread.sleep(sleepMSec);
						updateProgress(i, loopCount);
					}
					return null;
				}

				@Override
				protected void succeeded() {
					updateProgress(1, 1);
					super.succeeded();
					btn.setText("Restart");
					btn.setDisable(false);
				}
			};
			pgb.progressProperty().bind(task.progressProperty());
			pgi.progressProperty().bind(task.progressProperty());
			svc.submit(task);
			// begin the current game and product result
			gameResult = SportsProcessing.getCompeteResults(Main.sport);
			// set game compete time
			Main.currentGameTime = MainPage.getSystemTime();
			// fill the title of current result table
			currentResultsTable.getItems().clear();
			sportID = MainPage.getSportID(Main.currentGameType);
			gameID.setText(sportID);
			referee.setText(Main.sport.getReferee().getID() + "_" + Main.sport.getReferee().getName());
			// fill the Result table
			MainPage.setData3Values(data3, gameResult);
			currentResultsTable.setItems(data3);
			data3.removeAll();
			// Save game times to the database according to game type
			DatabaseConn.updateGameTimes(Main.sport.getSportsID());
			// Save the current game result to the TXT file
			MainPage.saveCurrResultToTXT(sportID, gameResult);
			// Save the points to relevant athletes
			MainPage.savePointsToDB(gameResult);
		} else {
			notice.setText("Please select a game before beignning");
		}
	}
}
