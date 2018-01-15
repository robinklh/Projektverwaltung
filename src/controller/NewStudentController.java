package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Student;

public class NewStudentController implements Initializable
{

   @FXML
   Button btnSave;

   @FXML
   Button btnCancel;

   @FXML
   TextField txtfieldName;

   @FXML
   TextField txtfieldPrename;

   @FXML
   TextField txtfieldMatrikel;

   @FXML
   TextField txtfieldContact;

   @Override

   public void initialize(URL location, ResourceBundle resources)
   {
      btnCancel.setOnAction(e -> {
         try
         {
            Scene scene = btnCancel.getScene();
            AnchorPane root = FXMLLoader
                  .load(getClass().getResource("../view/ShowStudents.fxml"));
            scene.setRoot(root);
         }
         catch (IOException e1)
         {
            e1.printStackTrace();
         }
      });

      btnSave.setOnAction(e -> {

         addStudent();
         try
         {
            Scene scene = btnCancel.getScene();
            AnchorPane root = FXMLLoader
                  .load(getClass().getResource("../view/ShowStudents.fxml"));
            scene.setRoot(root);
         }
         catch (IOException e1)
         {
            e1.printStackTrace();
         }
      });

   }

   private void addStudent()
   {
      final EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("projektverwaltung");
      final EntityManager entityManager = entityManagerFactory
            .createEntityManager();
      try
      {
         EntityTransaction entityTransaction = entityManager.getTransaction();
         entityTransaction.begin();

         Student newStudent = new Student(txtfieldPrename.getText(),
               txtfieldName.getText(),
               Integer.valueOf(txtfieldMatrikel.getText()),
               txtfieldContact.getText());
         entityManager.persist(newStudent);

         entityTransaction.commit();

         Alert alert = new Alert(AlertType.INFORMATION);
         alert.setTitle("Information");
         alert.setHeaderText(null);
         alert.setContentText("Student angelegt!");
         alert.showAndWait();

         return;
      }
      catch (Exception e)
      {
         entityManager.getTransaction().rollback();
         System.out.println("there was a problem: " + e.getMessage());
         return;
      }
   }

}
