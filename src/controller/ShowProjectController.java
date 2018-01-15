package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ShowProjectController implements Initializable
{

   @FXML
   TextField txtfieldTitel;

   @FXML
   TextArea txtAreaDescription;

   @FXML
   TextArea txtAreaSkizze;

   @FXML
   TextField txtfieldAnsprechpartner;

   @FXML
   TextField txtfieldSutdentOne;

   @FXML
   TextField txtfieldStudentTwo;

   @FXML
   Button btnCancel;

   @Override
   public void initialize(URL location, ResourceBundle resources)
   {
      btnCancel.setOnAction(e -> {
         try
         {
            Scene scene = btnCancel.getScene();
            AnchorPane root = FXMLLoader
                  .load(getClass().getResource("../view/ShowProjects.fxml"));
            scene.setRoot(root);
         }
         catch (IOException e1)
         {
            e1.printStackTrace();
         }
      });

      txtfieldTitel.setText("Test Titel");
      txtAreaSkizze.setText("Hier kommt die Skizze");
      txtAreaDescription.setText(
            "Das ist eine sehr schöne und sehr lange Beschreibung für das Projekt");
      txtfieldAnsprechpartner.setText("Frank Fischer");
      txtfieldSutdentOne.setText("Sandra Wenzel");
      txtfieldStudentTwo.setText("Fisch Kopf");

   }

}
