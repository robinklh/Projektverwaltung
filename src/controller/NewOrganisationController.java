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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class NewOrganisationController implements Initializable
{
   @FXML
   private Button btnCancel;

   @FXML
   private Button btnSave;

   @FXML
   Label lblUsername;

   @FXML
   TextField txtfieldName;

   @FXML
   TextField txtfieldPlz;

   @FXML
   TextField txtfieldCity;

   @FXML
   TextField txtfieldStreet;

   @FXML
   TextField txtfieldHousenumber;

   @FXML
   TextField txtfieldContact;

   @Override
   public void initialize(URL location, ResourceBundle resources)
   {
      btnCancel.setOnAction(e -> {
         try
         {
            Scene scene = btnCancel.getScene();
            AnchorPane root = FXMLLoader.load(
                  getClass().getResource("../view/ShowOrganisation.fxml"));
            scene.setRoot(root);
         }
         catch (IOException e1)
         {
            e1.printStackTrace();
         }
      });
   }

}
