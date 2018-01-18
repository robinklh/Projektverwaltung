package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import database.Session;
import database.StudentDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
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

   /**
    * initializes the Components of the NewStudentView. If the Clipboard is
    * not null and it contains a Object of the type Student the textfields are
    * going to be initialized with the proper values out of that Object and
    * the textfield for the matrikelnummer will be disabled because its the
    * primarykey and shouldn't be changed anyway.
    */
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
      }

      btnCancel.setOnAction(e -> handleCancel(e));

      btnSave.setOnAction(e -> handleSave(e));

   }

   /**
    * Handles the Click on the cancelButton. Cleans the clipboard and shows
    * the showStudents-View.
    * 
    * @param e
    *           unused.
    */
   private void handleCancel(ActionEvent e)
   {
      backToShowStudentView();
   }

   /**
    * Handles the Click on the saveButton. Differs whether an existing Student
    * has to be updated or a new one is to be inserted. After the
    * DatabaseOperation the clipboard is gonna be cleaned and the
    * showStudents-View will be shown.
    * 
    * @param e
    *           unused.
    */
   private void handleSave(ActionEvent e)
   {
      Student newStudent = new Student(txtfieldPrename.getText(),
            txtfieldName.getText(),
            Integer.valueOf(txtfieldMatrikel.getText()),
            txtfieldContact.getText());
      StudentDAO studentDAO = new StudentDAO();
      if (Session.getInstance().getClipboard() == null)
      {
         studentDAO.insertStudent(newStudent);
      }
      else
      {
         studentDAO.updateStudent(newStudent);
      }
      backToShowStudentView();
   }

   /**
    * cleans up the Clipboard and shows the ShowStudents-view. to get the
    * scene it uses btnCancel but it could've been any other component as
    * well.
    */
   private void backToShowStudentView()
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
}
