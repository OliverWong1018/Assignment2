package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
import model.Game;

public class MainPageController implements Initializable {

	@FXML
	private Button btn;

	@FXML
	private ProgressBar pgb;

	@FXML
	private Label lbl;

	@FXML
	private ProgressIndicator pgi;

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

	final ObservableList<Table3> data3 = FXCollections.observableArrayList(new Table3("1", "Wayne", "5.1", "5"),
			new Table3("2", "Oliver", "5.45", "4"), new Table3("3", "Tim", "6.05", "3"));

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
		iPoints3.setCellValueFactory(new PropertyValueFactory<Table3, String>("rPoints3"));

		currentResultsTable.setItems(data3);
	}
}
