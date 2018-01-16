package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import database.EntityManagerSingleton;
import database.Session;
import database.StudentDAO;
import javafx.event.ActionEvent;
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
      Session session = Session.getInstance();

      if (session.getClipboard() != null
            && session.getClipboard() instanceof Student)
      {

         Student student = (Student) session.getClipboard();
         txtfieldName.setText(student.getNachname());
         txtfieldPrename.setText(student.getVorname());
         txtfieldMatrikel
               .setText(String.valueOf(student.getMatrikelnummer()));
         txtfieldContact.setText(student.getMail());
         txtfieldMatrikel.setDisable(true);
         ;
      }

      btnCancel.setOnAction(e -> handleCancel(e));

      btnSave.setOnAction(e -> handleSave(e));

   }

   private void handleCancel(ActionEvent e)
   {
      try
      {
         Scene scene = btnCancel.getScene();
         Session.getInstance().removeClipboard();
         AnchorPane root = FXMLLoader
               .load(getClass().getResource("../view/ShowStudents.fxml"));
         scene.setRoot(root);
      }
      catch (IOException e1)
      {
         e1.printStackTrace();
      }
   }

   private void handleSave(ActionEvent e)
   {
      try
      {
         Scene scene = btnSave.getScene();
         if (Session.getInstance().getClipboard() == null)
         {
            addStudent();
         }
         else
         {
            StudentDAO studentDAO = new StudentDAO();
            studentDAO.updateStudent(new Student(txtfieldPrename.getText(),
                  txtfieldName.getText(),
                  Integer.parseInt(txtfieldMatrikel.getText()),
                  txtfieldContact.getText()));
            Session.getInstance().removeClipboard();
         }
         AnchorPane root = FXMLLoader
               .load(getClass().getResource("../view/ShowStudents.fxml"));
         scene.setRoot(root);
      }
      catch (IOException e1)
      {
         e1.printStackTrace();
      }

   }

   private void addStudent()
   {
      final EntityManager entityManager = EntityManagerSingleton
            .getInstance();
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
