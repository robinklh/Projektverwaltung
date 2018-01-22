package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import database.Session;
import database.StudentDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Student;

public class ShowStudentsController implements Initializable {
	@FXML
	private Button btnBack;

	@FXML
	private Button btnNew;

	@FXML
	private Button btnEdit;

	@FXML
	private Button btnDelete;

	@FXML
	private TableView<Student> tableStudents;

	@FXML
	private TableColumn<Student, String> columnPrename;

	@FXML
	private TableColumn<Student, String> columnName;

	@FXML
	private TableColumn<Student, Integer> columnNumber;

	private ObservableList<Student> list;

	private StudentDAO studentDAO;

	/**
	 * Initializes the ShowStudents-View.
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		studentDAO = new StudentDAO();
		list = FXCollections.observableArrayList(studentDAO.findAllStudents());

		columnPrename.setCellValueFactory(new PropertyValueFactory<Student, String>("vorname"));
		columnName.setCellValueFactory(new PropertyValueFactory<Student, String>("nachname"));
		columnNumber.setCellValueFactory(new PropertyValueFactory<Student, Integer>("matrikelnummer"));
		tableStudents.setItems(list);

		btnBack.setOnAction(e -> handleBackToProfMain(e));

		btnNew.setOnAction(e -> handleNewStudent(e));

		btnDelete.setOnAction(e -> handleDeleteStudent(e));

		btnEdit.setOnAction(e -> handleEditStudent(e));
	}

	/**
	 * Handles the button-click on the back-button.
	 * 
	 * @param e
	 *            unused.
	 */
	private void handleBackToProfMain(ActionEvent e) {
		try {
			Scene scene = btnBack.getScene();
			AnchorPane root = FXMLLoader.load(getClass().getResource("../view/ProfMain.fxml"));
			scene.setRoot(root);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Handles the button-click on the new-button.
	 * 
	 * @param e
	 *            unused.
	 */
	private void handleNewStudent(ActionEvent e) {
		try {
			Scene scene = btnNew.getScene();
			AnchorPane root = FXMLLoader.load(getClass().getResource("../view/NewStudent.fxml"));
			scene.setRoot(root);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Handles the button-click on the delete-button.
	 * 
	 * @param e
	 *            unused.
	 */
	private void handleDeleteStudent(ActionEvent e) {
		if (!tableStudents.getSelectionModel().getSelectedItems().isEmpty()) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Löschen?");
			alert.setHeaderText(null);
			alert.setContentText(
					"Möchten Sie wirklich " + tableStudents.getSelectionModel().getSelectedItem().getVorname() + " "
							+ tableStudents.getSelectionModel().getSelectedItem().getNachname() + " löschen?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				Student studentToRemove = tableStudents.getSelectionModel().getSelectedItem();
				list.remove(studentToRemove);
				studentDAO.deleteStudent(studentToRemove);
			} else {
				// not necessary
			}
		}

	}

	/**
	 * Handle the Button-click on the edit-button.
	 */
	private void handleEditStudent(ActionEvent e) {
		Session session = Session.getInstance();
		if (!tableStudents.getSelectionModel().getSelectedItems().isEmpty()) {
			session.setClipboard(tableStudents.getSelectionModel().getSelectedItem());
			try {
				Scene scene = btnNew.getScene();
				AnchorPane root = FXMLLoader.load(getClass().getResource("../view/NewStudent.fxml"));
				scene.setRoot(root);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
