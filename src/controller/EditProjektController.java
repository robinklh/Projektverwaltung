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

/**
 * @author robinklh
 *
 */
public class EditProjektController implements Initializable {

	@FXML
	Label lblUsername;
	@FXML
	TextField txtfieldTitel;
	@FXML
	TextArea txtAreaSkizze;
	@FXML
	TextField txtfieldStudentOne;
	@FXML
	Button btnCancel;
	@FXML
	Button btnSave;
	@FXML
	TextArea txtAreaComment;
	@FXML
	TextField txtfieldAnsprechpartner;
	@FXML
	TextField txtfieldStudentThree;
	@FXML
	TextArea txtAreaDescription;
	@FXML
	TextField txtfieldStudentTwo;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		showAntrag();
		btnCancel.setOnAction(e -> {
			backToStudentMain();
		});
		btnSave.setOnAction(e -> {
			saveProject();
			backToStudentMain();
		});
	}

	private void saveProject() {
		ProjektDAO projektDao = new ProjektDAO();
		Session session = Session.getInstance();
		Projekt projekt = ((Student) session.getLoggedInUser()).getProjekt();
		projekt.setProjektname(txtfieldTitel.getText());
		projekt.setProjektskizze(txtAreaSkizze.getText());
		projekt.setProjektbeschreibung(txtAreaDescription.getText());
		projekt.setAnmerkung(txtAreaComment.getText());
		projekt.setStatus("bearbeitung");
		projektDao.updateProject(projekt);
	}

	private void backToStudentMain() {
		try {
			Scene scene = btnCancel.getScene();
			AnchorPane root = FXMLLoader.load(getClass().getResource("../view/StudentMain.fxml"));
			scene.setRoot(root);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void showAntrag() {
		Session session = Session.getInstance();
		Projekt projekt = ((Student) session.getLoggedInUser()).getProjekt();

		txtfieldTitel.setText(projekt.getProjektname());
		txtAreaSkizze.setText(projekt.getProjektskizze());
		txtAreaDescription.setText(projekt.getProjektbeschreibung());
		txtfieldAnsprechpartner.setText(projekt.getAnsprechpartner().toString());

		ArrayList<Student> studenten = new ArrayList<>(projekt.getStudenten());

		txtfieldStudentOne.setText(studenten.get(0).toString());
		txtfieldStudentTwo.setText(studenten.get(1).toString());
		if (projekt.getStudenten().size() == 3) {
			txtfieldStudentThree.setText(studenten.get(2).toString());
		}
		txtfieldStudentOne.setDisable(true);
		txtfieldStudentTwo.setDisable(true);
		txtfieldStudentThree.setDisable(true);
		txtAreaComment.setDisable(true);

		if (!projekt.getStatus().equals("abgelehnt")) {
			txtAreaDescription.setDisable(true);
			txtAreaSkizze.setDisable(true);
			txtfieldAnsprechpartner.setDisable(true);
			txtfieldTitel.setDisable(true);
			btnSave.setVisible(false);
		}

		txtAreaComment.setText(projekt.getAnmerkung());
	}
}
