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

public class NewAnsprechpartnerController implements Initializable {

	@FXML
	Label lblUsername;

	@FXML
	Button btnSave;

	@FXML
	Button btnCancel;

	/**
	 * Initializes the Components of the NewAnsprechpartner-view.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnCancel.setOnAction(e -> {
			backToShowAnsprechpartner();
		});

		btnSave.setOnAction(e -> {
			// save
			backToShowAnsprechpartner();
		});

	}

	private void backToShowAnsprechpartner() {
		try {
			Scene scene = btnCancel.getScene();
			AnchorPane root = FXMLLoader.load(getClass().getResource("../view/ShowAnsprechpartner.fxml"));
			scene.setRoot(root);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
