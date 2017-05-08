package GUI;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Game;

public class Main extends Application {
	private static Stage primaryStage;
	private static BorderPane mainLayoutB;
	private static AnchorPane mainLayoutA;
	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Welcome");
		showWelcomeView();
	}

	private void showWelcomeView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/GUI/Welcome.fxml"));
		mainLayoutB = loader.load();
		Scene scene = new Scene(mainLayoutB);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void selectGamePage() throws IOException{
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/GUI/SelectGamePage.fxml"));
		mainLayoutA = loader.load();
		Scene scene = new Scene(mainLayoutA);
		stage.setScene(scene);
		stage.show();
		stage.setTitle("Ozlympic Games");
	}
	public static void showMainPageScene() throws IOException {
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/GUI/MainPage.fxml"));
		mainLayoutB = loader.load();
		Scene scene = new Scene(mainLayoutB);
		stage.setScene(scene);
		stage.show();
		stage.setTitle("Ozlympic");
	}

	public static void displayResult() throws IOException {
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/GUI/AllResults.fxml"));
		mainLayoutB = loader.load();
		Scene scene = new Scene(mainLayoutB);
		stage.setScene(scene);
		stage.show();
		stage.setTitle("All Results");
	}
	
	public static void closeWindow() throws IOException {
		primaryStage.hide();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static void showConstructGamePageScene() throws IOException {
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/GUI/GameConstractionPage.fxml"));
		mainLayoutA = loader.load();
		
		Scene scene = new Scene(mainLayoutA);
		stage.setScene(scene);
		stage.show();
		stage.setTitle("Game Constraction");
		
	}

	
}
