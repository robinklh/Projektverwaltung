package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import database.ProjektDAO;
import database.Session;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import model.Projekt;

public class ShowProjectsController implements Initializable
{

   @FXML
   Label lblUsername;

   @FXML
   ListView<Projekt> listViewProjects;

   @FXML
   Button btnBack;

   private ObservableList<Projekt> projects;

   @Override
   public void initialize(URL location, ResourceBundle resources)
   {
      Session session = Session.getInstance();

      ProjektDAO projektDao = new ProjektDAO();
      projects = FXCollections
            .observableArrayList(projektDao.findAllProjects("angenommen"));
      listViewProjects.setItems(projects);

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
      listViewProjects.setOnMousePressed(e -> {
         if (e.getButton() == MouseButton.PRIMARY && e.getClickCount() == 2)
         {
            try
            {
               session.setClipboard(
                     listViewProjects.getSelectionModel().getSelectedItem());
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

      });
   }

}
