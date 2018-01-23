package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import database.Session;
import database.StudentDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Student;

/**
 * Hier wird der Login ausgeführt noch ist das hier Tot und es wird nur
 * Weitergeleitet.
 * 
 * @author robinklh
 *
 */
public class MainController implements Initializable
{

   @FXML
   Button btnOK;

   @FXML
   Button btnStudent;

   @FXML
   Button btnProfessor;

   @FXML
   PasswordField password;

   @FXML
   TextField txtfieldName;

   /**
    * initializes the Main-View, which opens at the Applicationstart. At the
    * moment there is no login. So 2 buttons are used to show the student- and
    * the professor-part of the application.
    */
   @Override
   public void initialize(URL location, ResourceBundle resources)
   {
      btnOK.setOnAction(e -> {
         // handleLogin.
      });
      btnStudent.setOnAction(e -> {
         try
         {
            login();
            Scene scene = btnStudent.getScene();
            AnchorPane root = FXMLLoader
                  .load(getClass().getResource("../view/StudentMain.fxml"));
            scene.setRoot(root);
         }
         catch (IOException e1)
         {
            e1.printStackTrace();
         }
      });

      btnProfessor.setOnAction(e -> {
         try
         {
            Scene scene = btnProfessor.getScene();
            AnchorPane root = FXMLLoader
                  .load(getClass().getResource("../view/ProfMain.fxml"));
            scene.setRoot(root);
         }
         catch (IOException e1)
         {
            e1.printStackTrace();
         }
      });
   }

   private void login()
   {
      Session session = Session.getInstance();
      StudentDAO studentDao = new StudentDAO();
      Student loggedInUser = studentDao.login();
      session.setLoggedInUser(loggedInUser);
   }

}
