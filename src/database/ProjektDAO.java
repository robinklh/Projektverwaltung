package database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Projekt;
import model.Student;

public class ProjektDAO {

	private EntityManager em;

	/**
	 * gets the instance of the entitymanager needed.
	 */
	public ProjektDAO() {
		em = EntityManagerSingleton.getInstance();
	}

	public void insertProject(Projekt project) {
		try {
			em.getTransaction().begin();
			em.persist(project);
			for (Student student : project.getStudenten()) {
				student.setProjekt(project);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Konnte Projekt nicht speichern");
		}
	}

	public List<Projekt> findAllProjects(String status) {
		final TypedQuery<Projekt> typedQuery = em.createQuery("Select p from Projekt p where status = :status",
				Projekt.class);
		typedQuery.setParameter("status", status);
		return typedQuery.getResultList();
	}

	public void updateProject(Projekt projekt) {
		try {
			Projekt oldProjekt = findProjektById(projekt.getProjekt_id());
			em.getTransaction().begin();
			oldProjekt.setProjektname(projekt.getProjektname());
			oldProjekt.setProjektskizze(projekt.getProjektskizze());
			oldProjekt.setProjektbeschreibung(projekt.getProjektbeschreibung());
			oldProjekt.setAnmerkung(projekt.getAnmerkung());
			oldProjekt.setStatus(projekt.getStatus());
			em.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("failed to update Projekt " + projekt.getProjekt_id());
			em.getTransaction().rollback();
		}
	}

	private Projekt findProjektById(Integer projekt_id) {
		return em.find(Projekt.class, projekt_id);
	}

	public void deleteProjekt(Projekt projekt) {
		try {
			em.getTransaction().begin();
			for (Student student : projekt.getStudenten()) {
				student.setProjekt(null);
			}
			em.remove(projekt);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

}
