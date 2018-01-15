package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

//Hier wird der Login ausgeführt noch ist das hier Tod und es wird nur Weitergeleitet
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

   @Override
   public void initialize(URL location, ResourceBundle resources)
   {
      btnStudent.setOnAction(e -> {
         try
         {
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

}
