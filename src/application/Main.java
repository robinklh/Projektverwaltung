package application;

import java.util.logging.Level;
import java.util.logging.Logger;

import database.EntityManagerSingleton;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * <p>
 * Application-entrance
 * </p>
 * .
 * 
 * @author robinklh
 *
 */
public class Main extends Application {
	Logger logger = Logger.getLogger(Main.class.getName());

	/**
	 * starts the gui.
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = FXMLLoader.load(getClass().getResource("../view/main.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

			primaryStage.setOnCloseRequest(e -> {
				try {
					EntityManagerSingleton.destroy();
				} catch (Exception e1) {
					logger.log(Level.SEVERE, "Die EntitymanagerFactory konnte nicht geschlossen werden.", e1);
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * starts the application.
	 * 
	 * @param args
	 *            passed to the javafx-framework, but not really used.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
