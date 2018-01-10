package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Student;

public class ShowStudentsController implements Initializable {
	@FXML
	private Button btnBack;

	@FXML // Die Tabelle Selbst
	private TableView<Student> tableStudents;

	@FXML // Spalte Vorname
	private TableColumn<Student, String> columnPrename;

	@FXML // Spalte Nachname
	private TableColumn<Student, String> columnName;

	@FXML // Spalte Matrikelnummer
	private TableColumn<Student, Integer> columnNumber;

	// Hier m�ssen die Daten reingeladen werden Eventuell in Methode auslagern
	public ObservableList<Student> list;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		list = FXCollections.observableArrayList(getStudents());
		columnPrename.setCellValueFactory(new PropertyValueFactory<Student, String>("vorname"));
		columnName.setCellValueFactory(new PropertyValueFactory<Student, String>("nachname"));
		columnNumber.setCellValueFactory(new PropertyValueFactory<Student, Integer>("matrikelnummer"));
		tableStudents.setItems(list);

		btnBack.setOnAction(e -> {
			try {
				Scene scene = btnBack.getScene();
				AnchorPane root = FXMLLoader.load(getClass().getResource("../view/ProfMain.fxml"));
				scene.setRoot(root);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});

	}

	/**
	 * 
	 * @return
	 */
	public List<Student> getStudents() {
		List<Student> results = new ArrayList<>();
		final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projektverwaltung");
		final EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			TypedQuery<Object[]> query = entityManager
					.createQuery("SELECT s.vorname, s.nachname, s.matrikelnummer FROM Student s", Object[].class);
			List<Object[]> resultsList = query.getResultList();
			for (Object[] result : resultsList) {
				results.add(new Student((String) result[0], (String) result[1], (Integer) result[2]));
			}

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.out.println("there was a problem: " + e.getMessage());

		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		return results;
	}

}
