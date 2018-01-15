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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ShowAnträgeController implements Initializable
{

   @FXML
   Label lblUsername;

   @FXML
   ListView<String> listViewAntrag;

   @FXML
   Button btnBack;

   private ObservableList<String> list = FXCollections
         .observableArrayList("Hier steht ein Antrag");

   @Override
   public void initialize(URL location, ResourceBundle resources)
   {
      listViewAntrag.setItems(list);

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

      listViewAntrag.getSelectionModel()
            .setSelectionMode(SelectionMode.SINGLE);
      listViewAntrag.setOnMousePressed(new EventHandler<MouseEvent>()
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
                        getClass().getResource("../view/ShowAntrag.fxml"));
                  scene.setRoot(root);
               }
               catch (IOException e1)
               {
                  e1.printStackTrace();
               }
            }
         }
      });

   }

}
