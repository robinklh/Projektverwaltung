package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import database.Session;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import model.Projekt;
import model.Student;

public class StudentMainController implements Initializable {

	@FXML
	Button btnProject;

	@FXML
	Button btnMeeting;

	@FXML
	Label lblUsername;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Session session = Session.getInstance();
		Student loggedInUser = ((Student) session.getLoggedInUser());
		lblUsername.setText(loggedInUser.toString());
		if (loggedInUser.getProjekt() != null) {
			Projekt myProjekt = loggedInUser.getProjekt();
			btnProject.setText(myProjekt.getProjektname() + " : " + myProjekt.getStatus().toUpperCase());

			btnProject.setOnAction(e -> {
				try {
					Scene scene = btnProject.getScene();
					AnchorPane root = FXMLLoader.load(getClass().getResource("../view/EditProject.fxml"));
					scene.setRoot(root);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			});
		} else {
			btnProject.setOnAction(e -> {
				try {
					Scene scene = btnProject.getScene();
					AnchorPane root = FXMLLoader.load(getClass().getResource("../view/NewProject.fxml"));
					scene.setRoot(root);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			});
		}
	}

}
