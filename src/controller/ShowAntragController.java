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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ShowAntragController implements Initializable
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
   TextArea txtAreaComment;

   @FXML
   Button btnCancel;

   @FXML
   Button btnAccept;

   @FXML
   Button btnDecline;

   @FXML
   Label lblUsername;

   @Override
   public void initialize(URL location, ResourceBundle resources)
   {
      btnCancel.setOnAction(e -> {
         try
         {
            Scene scene = btnCancel.getScene();
            AnchorPane root = FXMLLoader
                  .load(getClass().getResource("../view/ShowAnträge.fxml"));
            scene.setRoot(root);
         }
         catch (IOException e1)
         {
            e1.printStackTrace();
         }
      });

      txtfieldTitel.setText("TestTitel");
      txtAreaSkizze.setText("Hier wäre dann die Skizze");
      txtAreaDescription.setText(
            "Eine tolle beschreibung für den Antrag kann hier hin egal wie lang");
      txtfieldAnsprechpartner.setText("Fisch Kopf");
      txtfieldSutdentOne.setText("Fabian Müller");
      txtfieldStudentTwo.setText("Der Grinch");
      txtAreaComment.setText("Hier können sie ein Kommentar hinterlassen");
   }

}
