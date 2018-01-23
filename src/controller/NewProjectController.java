package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import database.AnsprechpartnerDAO;
import database.ProjektDAO;
import database.Session;
import database.StudentDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import model.Projekt;
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
   TextArea txtAreaSkizze;

   @FXML
   TextArea txtAreaDescription;

   @FXML
   ComboBox<Ansprechpartner> comboAnsprechpartner;

   @FXML
   ComboBox<Student> comboStudentOne;

   @FXML
   ComboBox<Student> comboStudentTwo;

   private ObservableList<Student> studentList;

   private ObservableList<Ansprechpartner> ansprechpartnerList;

   @Override
   public void initialize(URL location, ResourceBundle resources)
   {
      btnCancel.setOnAction(e -> {
         backToStudentMain();
      });

      fillcomboboxes();

      btnSave.setOnAction(e -> {
         saveProject();
         backToStudentMain();
      });

   }

   private void fillcomboboxes()
   {
      StudentDAO studentDao = new StudentDAO();
      AnsprechpartnerDAO ansprechpartnerDao = new AnsprechpartnerDAO();
      studentList = FXCollections
            .observableArrayList(studentDao.findStudentsWithoutProject());
      comboStudentOne.setItems(studentList);
      comboStudentTwo.setItems(studentList);
      ansprechpartnerList = FXCollections
            .observableArrayList(ansprechpartnerDao.findallAnsprechpartner());
      comboAnsprechpartner.setItems(ansprechpartnerList);
   }

   private void saveProject()
   {
      String projekttitel = txtfieldTitel.getText();
      String projekskizze = txtAreaSkizze.getText();
      String projektbeschreibung = txtAreaDescription.getText();
      Ansprechpartner ansprechpartner = comboAnsprechpartner.getValue();
      Collection<Student> students = new ArrayList<>();
      students.add(comboStudentOne.getValue());

      if (comboStudentTwo.getSelectionModel().getSelectedItem() != null)
      {
         students.add(comboStudentTwo.getValue());
      }
      Student loggedInStudent = (Student) Session.getInstance()
            .getLoggedInUser();
      students.add(loggedInStudent);

      Projekt projekt = new Projekt(projekttitel, projekskizze,
            projektbeschreibung, students, ansprechpartner);

      ProjektDAO projektDao = new ProjektDAO();
      projektDao.insertProject(projekt);

   }

   private void backToStudentMain()
   {
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
   }

}
