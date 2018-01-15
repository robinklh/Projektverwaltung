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

	public List<Student> findAllStudents() {

		final TypedQuery<Student> query = em.createQuery("FROM Student", Student.class);

		return query.getResultList();

	}
}
