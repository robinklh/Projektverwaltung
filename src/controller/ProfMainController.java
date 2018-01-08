package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class ProfMainController implements Initializable {
	@FXML
	Button btnProposal;
	@FXML
	Button btnProject;
	@FXML
	Button btnStudents;
	@FXML
	Button btnCompany;
	@FXML
	Button btnMeeting;

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
	}
}
