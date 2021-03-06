package database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Student;

/**
 * <p>
 * Data-Access-Object
 * </p>
 * for the entity Student.
 * 
 * @author robinklh
 *
 */
public class StudentDAO {

	private EntityManager em;

	/**
	 * gets the instance of the entitymanager needed.
	 */
	public StudentDAO() {
		em = EntityManagerSingleton.getInstance();
	}

	/**
	 * Selects all Students persisted in the database.
	 * 
	 * @return List of Students.
	 */
	public List<Student> findAllStudents() {
		final TypedQuery<Student> query = em.createQuery("FROM Student", Student.class);

		return query.getResultList();
	}

	/**
	 * Selects the Student identified by the given Matrikelnummer.
	 * 
	 * @param matrikelnummer
	 *            identifies the Student.
	 * @return A Student.
	 */
	public Student findStudentByMatrikelnummer(int matrikelnummer) {
		return em.find(Student.class, matrikelnummer);
	}

	/**
	 * Deletes a Student from the Database.
	 * 
	 * @param student
	 *            to remove.
	 */
	public void deleteStudent(Student student) {
		try {
			em.getTransaction().begin();
			em.remove(student);
			em.getTransaction().commit();
		} catch (Exception e1) {
			System.out.println("failed to delete Student " + student.getMatrikelnummer());
			em.getTransaction().rollback();
		}
	}

	/**
	 * Updates a Student from the Database.
	 * 
	 * @param student
	 *            to update.
	 */
	public void updateStudent(Student student) {
		try {
			Student oldStudent = findStudentByMatrikelnummer(student.getMatrikelnummer());
			em.getTransaction().begin();
			oldStudent.setMail(student.getMail());
			oldStudent.setNachname(student.getNachname());
			oldStudent.setVorname(student.getVorname());
			em.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("failed to update Student " + student.getMatrikelnummer());
			em.getTransaction().rollback();
		}
	}

	/**
	 * Inserts a Student into the Database.
	 * 
	 * @param student
	 *            to insert.
	 */
	public void insertStudent(Student student) {
		final EntityManager entityManager = EntityManagerSingleton.getInstance();
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(student);
			entityTransaction.commit();

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information");
			alert.setHeaderText(null);
			alert.setContentText("Student angelegt!");
			alert.showAndWait();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.out.println("there was a problem: " + e.getMessage());
		}
	}

	public List<Student> findStudentsWithoutProject() {
		final EntityManager entityManager = EntityManagerSingleton.getInstance();
		return entityManager.createQuery("select s from Student s where Projekt_id is null", Student.class)
				.getResultList();
	}

	public Student login() {
		return em.find(Student.class, 123456);
	}
}
