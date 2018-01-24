package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Ansprechpartner;

public class ShowAnsprechpartnerController implements Initializable
{
   @FXML
   private Label lblCompany;

   @FXML
   private Label lblAddress;

   @FXML
   private Button btnBack;

   @FXML
   private Button btnNew;

   @FXML
   private TableView<Ansprechpartner> tableEmployee;

   @FXML
   private TableColumn<Ansprechpartner, String> columnName;

   @FXML
   private TableColumn<Ansprechpartner, String> columnPrename;

   @FXML
   private TableColumn<Ansprechpartner, String> columnContact;

   // Hier die Liste mit den Werten füllen !!! PROBLEM wie Filtern? !!!
   public ObservableList<Ansprechpartner> list = FXCollections
         .observableArrayList(
               new Ansprechpartner("Meik", "Müller", "XXX@Web.de"));

   @Override
   public void initialize(URL arg0, ResourceBundle arg1)
   {
      columnPrename.setCellValueFactory(
            new PropertyValueFactory<Ansprechpartner, String>("vorname"));
      columnName.setCellValueFactory(
            new PropertyValueFactory<Ansprechpartner, String>("nachname"));
      columnContact.setCellValueFactory(
            new PropertyValueFactory<Ansprechpartner, String>("contact"));
      tableEmployee.setItems(list);

      btnBack.setOnAction(e -> {
         try
         {
            Scene scene = btnBack.getScene();
            AnchorPane root = FXMLLoader.load(
                  getClass().getResource("../view/ShowOrganisation.fxml"));
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
            AnchorPane root = FXMLLoader.load(
                  getClass().getResource("../view/NewAnsprechpartner.fxml"));
            scene.setRoot(root);
         }
         catch (IOException e1)
         {
            e1.printStackTrace();
         }
      });

   }

}
