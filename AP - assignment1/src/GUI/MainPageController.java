package GUI;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import model.Game;

public class MainPageController {

	@FXML
	private Button btn;

	@FXML
	private ProgressBar pgb;

	@FXML
	private Label lbl;

	@FXML
	private ProgressIndicator pgi;

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
	void initialize() {
		assert btn != null : "fx:id=\"btn\" was not injected: check your FXML file 'Progress.fxml'.";
		assert pgb != null : "fx:id=\"pgb\" was not injected: check your FXML file 'Progress.fxml'.";
		assert pgi != null : "fx:id=\"pgi\" was not injected: check your FXML file 'Progress.fxml'.";
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
}
