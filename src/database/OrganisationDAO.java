/**
 * 
 */
package database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Organisation;
import model.Student;

/**
 * @author Robin
 *
 */
public class OrganisationDAO {
	EntityManager em;

	public OrganisationDAO(EntityManager em) {
		if (em == null) {
			throw new NullPointerException("EntityManager should not be null.");
		}
		this.em = em;
	}

	public List<Organisation> findAllOrganisations() {
		final TypedQuery<Organisation> query = em.createQuery("FROM Organisation", Organisation.class);

		return query.getResultList();
	}

	/**
	 * Selects the Organisation identified by the given ID.
	 * 
	 * @param id
	 *            identifies the Organisation.
	 * @return An Organisation.
	 */
	public Student findOrganisationById(int id) {
		return em.find(Student.class, id);
	}
}
