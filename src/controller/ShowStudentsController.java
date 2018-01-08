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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Student;

public class ShowStudentsController implements Initializable
{
   @FXML
   private Button btnBack;

   @FXML // Die Tabelle Selbst
   private TableView<Student> tableStudents;

   @FXML // Spalte Vorname
   private TableColumn<Student, String> columnPrename;

   @FXML // Spalte Nachname
   private TableColumn<Student, String> columnName;

   @FXML // Spalte Matrikelnummer
   private TableColumn<Student, Integer> columnNumber;

   // Hier müssen die Daten reingeladen werden Eventuell in Methode auslagern
   public ObservableList<Student> list = FXCollections.observableArrayList(
         new Student("Meik", "Müller", 10049463),
         new Student("Robin", "Klüh", 10049563));

   @Override
   public void initialize(URL arg0, ResourceBundle arg1)
   {
      columnPrename.setCellValueFactory(
            new PropertyValueFactory<Student, String>("vorname"));
      columnName.setCellValueFactory(
            new PropertyValueFactory<Student, String>("nachname"));
      columnNumber.setCellValueFactory(
            new PropertyValueFactory<Student, Integer>("matrikelnummer"));
      tableStudents.setItems(list);

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

   }

}
