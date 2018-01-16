package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

<<<<<<< HEAD
public class Main extends Application
{
   @Override
   public void start(Stage primaryStage)
   {
      try
      {
         AnchorPane root = FXMLLoader
               .load(getClass().getResource("../view/Main.fxml"));
         Scene scene = new Scene(root);
         scene.getStylesheets().add(getClass()
               .getResource("../view/application.css").toExternalForm());
         primaryStage.setScene(scene);
         primaryStage.show();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   public static void main(String[] args)
   {

      launch(args);
   }

   @SuppressWarnings("unused")
   private static void performJPAActions(EntityManager entityManager)
   {
      // TODO Auto-generated method stub

   }

   @SuppressWarnings("unused")
   private static void executeStatements(EntityManager entityManager)
   {
      // TODO Auto-generated method stub
      final Student st = new Student("Hans", "Peter", 10900450);
      entityManager.persist(st);
   }
=======
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = FXMLLoader.load(getClass().getResource("../view/ShowStudents.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

>>>>>>> 3a6391f0fbac6c04746ed696c1e9664299fe2e03
}
