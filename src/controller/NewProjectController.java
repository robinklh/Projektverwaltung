package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Ansprechpartner;
import model.Student;

public class NewProjectController implements Initializable
{

   @FXML
   Label lblUsername;

   @FXML
   Button btnCancel;

   @FXML
   Button btnSave;

   @FXML
   TextField txtfieldTitel;

   @FXML
   TextArea txtAreaDescription;

   @FXML
   TextArea txtAreaSkizze;

   @FXML
   ComboBox<Ansprechpartner> comboContact;

   @FXML
   ComboBox<Student> comboStudentOne;

   @FXML
   ComboBox<Student> comboStudentTwo;

   @FXML
   TextField txtfieldAnsprechpartner;

   @FXML
   TextField txtfieldSutdentOne;

   @FXML
   TextField txtfieldStudentTwo;

   @Override
   public void initialize(URL location, ResourceBundle resources)
   {
      btnCancel.setOnAction(e -> {
         try
         {
            Scene scene = btnCancel.getScene();
            AnchorPane root = FXMLLoader
                  .load(getClass().getResource("../view/StudentMain.fxml"));
            scene.setRoot(root);
         }
         catch (IOException e1)
         {
            e1.printStackTrace();
         }
      });

   }

}
