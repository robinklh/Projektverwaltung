package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Organisation;

public class ShowCompanyController implements Initializable
{
   @FXML
   private Button btnBack;

   @FXML
   private Button btnNew;

   @FXML
   private ListView<String> listViewCompany;

   // Hier die Daten für Die Unternehmen reinladen vitl in extra Methode...
   private ObservableList<String> list = FXCollections.observableArrayList(
         new Organisation("FH Südwestfalen").getName(),
         new Organisation("Materna").getName());

   @Override
   public void initialize(URL location, ResourceBundle resources)
   {
      listViewCompany.setItems(list);

      // Hier wird der durch den Doppelten Mausklick auf die Unternehmensseite
      // verwiesen
      listViewCompany.getSelectionModel()
            .setSelectionMode(SelectionMode.SINGLE);
      listViewCompany.setOnMousePressed(new EventHandler<MouseEvent>()
      {
         @Override
         public void handle(MouseEvent event)
         {
            if (event.getButton() == MouseButton.PRIMARY
                  && event.getClickCount() == 2)
            {
               try
               {
                  Scene scene = btnBack.getScene();
                  AnchorPane root = FXMLLoader.load(
                        getClass().getResource("../view/ShowEmployee.fxml"));
                  scene.setRoot(root);
               }
               catch (IOException e1)
               {
                  e1.printStackTrace();
               }
            }
         }
      });

      btnBack.setOnAction(e -> {
         try
         {
            Scene scene = btnBack.getScene();
            AnchorPane root = FXMLLoader
                  .load(getClass().getResource("../view/ProfMain.fxml"));
            scene.setRoot(root);
         }
         catch (IOException e1)
         {
            e1.printStackTrace();
         }
      });

      btnNew.setOnAction(e -> {
         try
         {
            Scene scene = btnNew.getScene();
            AnchorPane root = FXMLLoader
                  .load(getClass().getResource("../view/NewCompany.fxml"));
            scene.setRoot(root);
         }
         catch (IOException e1)
         {
            e1.printStackTrace();
         }
      });

   }

}
