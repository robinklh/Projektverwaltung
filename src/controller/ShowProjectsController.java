package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
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
import model.Ansprechpartner;
import model.Projekt;
import model.Student;

public class ShowProjectsController implements Initializable
{

   @FXML
   Label lblUsername;

   @FXML
   ListView<String> listViewProjects;

   @FXML
   Button btnBack;

   private Collection<Student> students = new ArrayList<Student>();

   @Override
   public void initialize(URL location, ResourceBundle resources)
   {

      students.add(new Student("Sandra", "Wenzel", 1111111));
      students.add(new Student("Fisch", "Kopf", 1111));
      ObservableList<String> list = FXCollections
            .observableArrayList(new Projekt("TestName", "TestSkizze",
                  "TestBeschreibung", students,
                  new Ansprechpartner("Meik", "Müller", "xxx@xxx.xx"))
                        .getProjektname());

      listViewProjects.setItems(list);

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

      listViewProjects.getSelectionModel()
            .setSelectionMode(SelectionMode.SINGLE);
      listViewProjects.setOnMousePressed(new EventHandler<MouseEvent>()
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
                        getClass().getResource("../view/ShowProject.fxml"));
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
