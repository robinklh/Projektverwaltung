/**
 * 
 */
package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Student;

/**
 * @author Robin
 *
 */
public class StudentDAO {
	EntityManager em;

	public StudentDAO(EntityManager em) {
		if (em == null) {
			throw new NullPointerException("EntityManager should not be null.");
		}
		this.em = em;
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
}
