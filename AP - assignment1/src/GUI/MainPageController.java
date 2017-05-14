package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.AllResultsTXT;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.CompeteResult;
import model.Game;
import model.SportsPreparing;
import model.Swimming;

public class MainPageController implements Initializable {
	ArrayList<CompeteResult> gameResult = new ArrayList<CompeteResult>();
	String competeResultString = null;
	String newResult =null;
	String titles = null;
	@FXML
	private Button btn;

	@FXML
	private ProgressBar pgb;

	@FXML
	private Label gameID;

	@FXML
	private ProgressIndicator pgi;
	
	@FXML
	private Label referee;
	
	

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
	}
	
	@FXML
	private void goPoints() throws IOException {
		Main.displayPoints();
	}

	private ExecutorService svc = Executors.newSingleThreadExecutor();

	protected ExecutorService getService() {
		return svc;
	}

	@FXML
	void btnOnAction(ActionEvent e) {
		//fill the table of current result
		currentResultsTable.getItems().clear();
		int gameTimes = 0;
		String sportID = null; 
		if(Main.currentGameType.equals("s")){
			gameTimes = DatabaseConn.getGameTimes("swimming");
			
			if (gameTimes < 10) {
				sportID = "S0" + gameTimes;
			} else {
				sportID = "S" + gameTimes;
			}
		}
		if(Main.currentGameType.equals("r")){
			gameTimes = DatabaseConn.getGameTimes("running");
			if (gameTimes < 10) {
				sportID = "R0" + gameTimes;
			} else {
				sportID = "R" + gameTimes;
			}
		
		}
		if(Main.currentGameType.equals("c")){
			gameTimes = DatabaseConn.getGameTimes("cycling");
			if (gameTimes < 10) {
				sportID = "C0" + gameTimes;
			} else {
				sportID = "C" + gameTimes;
			}
		}
		gameID.setText(sportID);
		referee.setText(Main.sport.getReferee().getID()+"_"+Main.sport.getReferee().getName());
		gameResult = SportsPreparing.getCompeteResults(Main.sport);
		Iterator<CompeteResult> iter = gameResult.iterator();
		CompeteResult competeResult;
		do {
			competeResult = iter.next();
			data3.add(new Table3("","","","",""));
		    int f = data3.size()-1;
		     data3.get(f).setRank3(Integer.toString(competeResult.getRank()));
		     data3.get(f).setRID3(competeResult.getAthlete().getID());
		     data3.get(f).setRName3(competeResult.getAthlete().getName());
		     data3.get(f).setRType3(competeResult.getAthlete().getType());
		     data3.get(f).setRTime3(Integer.toString(competeResult.getTime()));
		} while (iter.hasNext());
		currentResultsTable.setItems(data3);
		data3.removeAll();
		//Save game times to the database according to game type
		DatabaseConn.updateGameTimes(Main.sport.getSportsID());
		//Save the current game result to the TXT file
		competeResultString = "";
		String titles = "Rank"+"  "+" ID  "+"  "+" Time "+"  "+"   Type   "+"  "+"  Name";
		iter = gameResult.iterator();
		for(int i =0;i<3;i++){
			competeResult = iter.next();
			
			competeResultString+= (Integer.toString(competeResult.getRank())+"   "+"||"+competeResult.getAthlete().getID()+"  "+"||"+Integer.toString(competeResult.getTime())
					+"   "+"||"+competeResult.getAthlete().getType()+"  "+"||"+competeResult.getAthlete().getName()+"\n");
		}
		newResult = sportID+"\n"+Main.sport.getReferee().getID()+"_"+Main.sport.getReferee().getName()
				+"\n"+titles+"\n"+competeResultString+"\n";
		AllResultsTXT.UpdateGamesResults(newResult);
		//Save the points to relevant athletes
		iter = gameResult.iterator();
		do {
			 competeResult = iter.next();
		     if(competeResult.getRank()==1){      
		     DatabaseConn.updateAthletePoints(competeResult.getAthlete().getID(), 5);
		     }
		     if(competeResult.getRank()==2){      
			     DatabaseConn.updateAthletePoints(competeResult.getAthlete().getID(), 2);
			 }
		     if(competeResult.getRank()==3){      
			     DatabaseConn.updateAthletePoints(competeResult.getAthlete().getID(), 1);
			 }
		} while (iter.hasNext());
		//process bar
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

			@Override
			protected void cancelled() {
				super.cancelled();
				btn.setText("Restart");
				btn.setDisable(false);
			}

			@Override
			protected void failed() {
				super.failed();
				btn.setText("Restart");
				btn.setDisable(false);
			}

		};

		pgb.progressProperty().bind(task.progressProperty());
		pgi.progressProperty().bind(task.progressProperty());

		svc.submit(task);
	}
	final ObservableList<Table3> data3 = FXCollections.observableArrayList();
	/*final ObservableList<Table3> data3 = FXCollections.observableArrayList(
			new Table3("1", "A01", "Wayne", "Swimmer","5.49"),
			new Table3("2", "A02", "Oliver", "Swimmer","6.05"), 
			new Table3("3", "A03", "Tim", "Swimmer","7.05"));
*/
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
		iTime3.setCellValueFactory(new PropertyValueFactory<Table3, String>("rTime3"));

		
	}
}
