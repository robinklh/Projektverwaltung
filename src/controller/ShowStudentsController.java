package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import database.Session;
import database.StudentDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Student;

public class ShowStudentsController implements Initializable
{
   @FXML
   private Button btnBack;

   @FXML
   private Button btnNew;

   @FXML
   private Button btnEdit;

   @FXML
   private Button btnDelete;

   @FXML // Die Tabelle Selbst
   private TableView<Student> tableStudents;

   @FXML // Spalte Vorname
   private TableColumn<Student, String> columnPrename;

   @FXML // Spalte Nachname
   private TableColumn<Student, String> columnName;

   @FXML // Spalte Matrikelnummer
   private TableColumn<Student, Integer> columnNumber;

   // Hier müssen die Daten reingeladen werden Eventuell in Methode auslagern
   private ObservableList<Student> list;

   private StudentDAO studentDAO;

   @Override
   public void initialize(URL arg0, ResourceBundle arg1)
   {
      Session session = Session.getInstance();
      studentDAO = new StudentDAO();
      list = FXCollections.observableArrayList(studentDAO.findAllStudents());

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

      btnNew.setOnAction(e -> {
         try
         {
            Scene scene = btnNew.getScene();
            AnchorPane root = FXMLLoader
                  .load(getClass().getResource("../view/NewStudent.fxml"));
            scene.setRoot(root);
         }
         catch (IOException e1)
         {
            e1.printStackTrace();
         }
      });

      btnDelete.setOnAction(e -> {
         if (!tableStudents.getSelectionModel().getSelectedItems().isEmpty())
         {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Löschen?");
            alert.setHeaderText(null);
            alert.setContentText("Möchten Sie wirklich "
                  + tableStudents.getSelectionModel().getSelectedItem()
                        .getVorname()
                  + " " + tableStudents.getSelectionModel().getSelectedItem()
                        .getNachname()
                  + " löschen?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK)
            {
               Student studentToRemove = tableStudents.getSelectionModel()
                     .getSelectedItem();
               list.remove(studentToRemove);
               studentDAO.deleteStudent(studentToRemove);
            }
            else
            {
               System.out.println("test2");
            }
         }

      });

      btnEdit.setOnAction(e -> {
         if (!tableStudents.getSelectionModel().getSelectedItems().isEmpty())
         {
            session.setClipboard(
                  tableStudents.getSelectionModel().getSelectedItem());
            try
            {

               Scene scene = btnNew.getScene();
               AnchorPane root = FXMLLoader
                     .load(getClass().getResource("../view/NewStudent.fxml"));

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
