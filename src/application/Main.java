package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Student;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = FXMLLoader.load(getClass().getResource("../view/ProfMain.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projektverwaltung");
		final EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			performJPAActions(entityManager);
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}

		launch(args);
	}

	private static void performJPAActions(EntityManager entityManager) {
		// TODO Auto-generated method stub
		try {
			entityManager.getTransaction().begin();
			executeStatements(entityManager);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.out.println("there was a problem");
		}

	}

	private static void executeStatements(EntityManager entityManager) {
		// TODO Auto-generated method stub
		final Student st = new Student("Hans", "Peter", 10900459);
		entityManager.persist(st);
	}
}
