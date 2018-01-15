package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class StudentMainController implements Initializable
{

   @FXML
   Button btnProject;

   @FXML
   Button btnMeeting;

   @FXML
   Label lblUsername;

   @Override
   public void initialize(URL location, ResourceBundle resources)
   {
      btnProject.setOnAction(e -> {
         try
         {
            Scene scene = btnProject.getScene();
            AnchorPane root = FXMLLoader
                  .load(getClass().getResource("../view/NewProject.fxml"));
            scene.setRoot(root);
         }
         catch (IOException e1)
         {
            e1.printStackTrace();
         }
      });
   }

}
