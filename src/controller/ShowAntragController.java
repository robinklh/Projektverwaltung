package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import database.ProjektDAO;
import database.Session;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Projekt;
import model.Student;

public class ShowAntragController implements Initializable
{

   @FXML
   TextField txtfieldTitel;

   @FXML
   TextArea txtAreaDescription;

   @FXML
   TextArea txtAreaSkizze;

   @FXML
   TextField txtfieldAnsprechpartner;

   @FXML
   TextField txtfieldStudentOne;

   @FXML
   TextField txtfieldStudentTwo;

   @FXML
   TextArea txtAreaComment;

   @FXML
   Button btnCancel;

   @FXML
   Button btnAccept;

   @FXML
   Button btnDecline;

   @FXML
   Label lblUsername;

   @FXML
   TextField txtfieldStudentThree;

   @Override
   public void initialize(URL location, ResourceBundle resources)
   {
      showAntrag();

      btnCancel.setOnAction(e -> {
         handleBack();
      });

      btnAccept.setOnAction(e -> {
         acceptProject();
         handleBack();
      });

      btnDecline.setOnAction(e -> {
         declineProject();
         handleBack();
      });

   }

   private void declineProject()
   {
      ProjektDAO projektDao = new ProjektDAO();
      Session session = Session.getInstance();
      Projekt projekt = (Projekt) session.getClipboard();
      projekt.setProjektname(txtfieldTitel.getText());
      projekt.setProjektskizze(txtAreaSkizze.getText());
      projekt.setProjektbeschreibung(txtAreaDescription.getText());
      projekt.setAnmerkung(txtAreaComment.getText());
      projekt.setStatus("abgelehnt");
      projektDao.evaluateProject(projekt);
   }

   private void acceptProject()
   {
      ProjektDAO projektDao = new ProjektDAO();
      Session session = Session.getInstance();
      Projekt projekt = (Projekt) session.getClipboard();
      projekt.setProjektname(txtfieldTitel.getText());
      projekt.setProjektskizze(txtAreaSkizze.getText());
      projekt.setProjektbeschreibung(txtAreaDescription.getText());
      projekt.setAnmerkung(txtAreaComment.getText());
      projekt.setStatus("angenommen");
      projektDao.evaluateProject(projekt);
   }

   private void showAntrag()
   {
      Session session = Session.getInstance();
      Projekt projekt = (Projekt) session.getClipboard();

      txtfieldTitel.setText(projekt.getProjektname());
      txtAreaSkizze.setText(projekt.getProjektskizze());
      txtAreaDescription.setText(projekt.getProjektbeschreibung());
      txtfieldAnsprechpartner
            .setText(projekt.getAnsprechpartner().toString());

      ArrayList<Student> studenten = new ArrayList<>(projekt.getStudenten());

      txtfieldStudentOne.setText(studenten.get(0).toString());
      txtfieldStudentTwo.setText(studenten.get(1).toString());
      if (projekt.getStudenten().size() == 3)
      {
         txtfieldStudentThree.setText(studenten.get(2).toString());
      }
      txtfieldStudentOne.setDisable(true);
      txtfieldStudentTwo.setDisable(true);
      txtfieldStudentThree.setDisable(true);

      txtAreaComment.setText("");
   }

   private void handleBack()
   {
      try
      {
         Session session = Session.getInstance();
         session.removeClipboard();
         Scene scene = btnCancel.getScene();
         AnchorPane root = FXMLLoader
               .load(getClass().getResource("../view/ShowAnträge.fxml"));
         scene.setRoot(root);
      }
      catch (IOException e1)
      {
         e1.printStackTrace();
      }
   }
}
