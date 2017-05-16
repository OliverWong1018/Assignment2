//Author is WEN ZHANG
package GUI;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Sports;
//Main class for creating stage.
public class Main extends Application {
	private static Stage primaryStage;
	private static BorderPane mainLayoutB;
	private static AnchorPane mainLayoutA;
	private static Stage selectgameStage = new Stage();
	public static String currentGameType=null;
	public static String currentGameTime=null;
	public static Sports sport = null;
	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Welcome");
		showWelcomeView();
	}
	// show welcome page;
	private void showWelcomeView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/GUI/Welcome.fxml"));
		mainLayoutB = loader.load();
		Scene scene = new Scene(mainLayoutB);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	//show select game Page
	public static void selectGamePage() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/GUI/SelectGamePage.fxml"));
		mainLayoutA = loader.load();
		Scene scene = new Scene(mainLayoutA);
		selectgameStage.setScene(scene);
		selectgameStage.show();
		selectgameStage.setTitle("Select Games");
	}
	//show main page
	public static void showMainPageScene() throws IOException {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/GUI/MainPage.fxml"));
		mainLayoutB = loader.load();
		Scene scene = new Scene(mainLayoutB);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("Ozlympic");
	}
	//show result page
	public static void displayResult() throws IOException {
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/GUI/ResultsPage.fxml"));
		mainLayoutB = loader.load();
		Scene scene = new Scene(mainLayoutB);
		stage.setScene(scene);
		stage.show();
		stage.setTitle("All Results");	
	}
	//show points page
	public static void displayPoints() throws IOException {
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/GUI/PointsPage.fxml"));
		mainLayoutB = loader.load();
		Scene scene = new Scene(mainLayoutB);
		stage.setScene(scene);
		stage.show();
		stage.setTitle("All Points");
	}
	//close window button
	public static void closeWindow() throws IOException {
		primaryStage.close();
	}
	//show select player page
	public static void showConstructGamePageScene() throws IOException {
	
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/GUI/GameBuildPage.fxml"));
		mainLayoutA = loader.load();
		Scene scene = new Scene(mainLayoutA);
		selectgameStage.setScene(scene);
		selectgameStage.show();	
	}
}
