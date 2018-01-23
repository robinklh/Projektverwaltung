package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import database.Session;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Projekt;
import model.Student;

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

   @FXML
   TextField txtfieldStudentThree;

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

      showProject();

   }

   private void showProject()
   {
      Session session = Session.getInstance();
      Projekt projekt = (Projekt) session.getClipboard();

      txtfieldTitel.setText(projekt.getProjektname());
      txtAreaSkizze.setText(projekt.getProjektskizze());
      txtAreaDescription.setText(projekt.getProjektbeschreibung());
      txtfieldAnsprechpartner
            .setText(projekt.getAnsprechpartner().toString());

      ArrayList<Student> studenten = new ArrayList<>(projekt.getStudenten());

      txtfieldSutdentOne.setText(studenten.get(0).toString());
      txtfieldStudentTwo.setText(studenten.get(1).toString());
      if (projekt.getStudenten().size() == 3)
      {
         txtfieldStudentThree.setText(studenten.get(2).toString());
      }
      txtfieldSutdentOne.setDisable(true);
      txtfieldStudentTwo.setDisable(true);
      txtfieldStudentThree.setDisable(true);
   }

}
