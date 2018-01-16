package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

<<<<<<< HEAD
public class ProfMainController implements Initializable
{
   @FXML
   private Button btnProposal;

   @FXML
   private Button btnProject;

   @FXML
   private Button btnStudents;

   @FXML
   private Button btnCompany;

   @FXML
   private Button btnMeeting;

   @FXML
   Label lblUsername;

   @Override
   public void initialize(URL location, ResourceBundle resources)
   {
      btnStudents.setOnAction(e -> {
         try
         {
            Scene scene = btnStudents.getScene();
            AnchorPane root = FXMLLoader
                  .load(getClass().getResource("../view/ShowStudents.fxml"));
            scene.setRoot(root);
         }
         catch (IOException e1)
         {
            e1.printStackTrace();
         }
      });

      btnCompany.setOnAction(e -> {
         try
         {
            Scene scene = btnStudents.getScene();
            AnchorPane root = FXMLLoader.load(
                  getClass().getResource("../view/ShowOrganisation.fxml"));
            scene.setRoot(root);
         }
         catch (IOException e1)
         {
            e1.printStackTrace();
         }
      });

      btnProject.setOnAction(e -> {
         try
         {
            Scene scene = btnProject.getScene();
            AnchorPane root = FXMLLoader
                  .load(getClass().getResource("../view/ShowProjects.fxml"));
            scene.setRoot(root);
         }
         catch (IOException e1)
         {
            e1.printStackTrace();
         }
      });

      btnProposal.setOnAction(e -> {
         try
         {
            Scene scene = btnProposal.getScene();
            AnchorPane root = FXMLLoader
                  .load(getClass().getResource("../view/ShowAnträge.fxml"));
            scene.setRoot(root);
         }
         catch (IOException e1)
         {
            e1.printStackTrace();
         }
      });

   }
=======
public class ProfMainController implements Initializable {
	@FXML
	private Button btnProposal;

	@FXML
	private Button btnProject;

	@FXML
	private Button btnStudents;

	@FXML
	private Button btnCompany;

	@FXML
	private Button btnMeeting;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnStudents.setOnAction(e -> {
			try {
				Scene scene = btnStudents.getScene();
				AnchorPane root = FXMLLoader.load(getClass().getResource("../view/ShowStudents.fxml"));
				scene.setRoot(root);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});

		btnCompany.setOnAction(e -> {
			try {
				Scene scene = btnCompany.getScene();
				AnchorPane root = FXMLLoader.load(getClass().getResource("../view/ShowCompany.fxml"));
				scene.setRoot(root);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});

	}
>>>>>>> 3a6391f0fbac6c04746ed696c1e9664299fe2e03
}
