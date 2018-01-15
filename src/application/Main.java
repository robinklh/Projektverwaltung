package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import service.StudentDAO;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = FXMLLoader.load(getClass().getResource("../view/ShowStudents.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

			final EntityManagerFactory entityManagerFactory = Persistence
					.createEntityManagerFactory("projektverwaltung");
			final EntityManager entityManager = entityManagerFactory.createEntityManager();
			StudentDAO dao = new StudentDAO(entityManager);
			dao.findAllStudents();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		launch(args);
	}

	private static void performJPAActions(EntityManager entityManager) {
		// TODO Auto-generated method stub

	}
}
