package database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerSingleton {
	private EntityManagerSingleton() {
		// Hier gibt es nichts zusehn.
	}

	private static EntityManagerFactory factory;
	private static EntityManager entitymanager;

	public static EntityManager getInstance() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("projektverwaltung");
		}
		if (entitymanager == null) {
			entitymanager = factory.createEntityManager();
		}
		return entitymanager;
	}

	public static void destroy() throws Exception {
		if (factory != null) {
			factory.close();
		}
		if (entitymanager != null) {
			entitymanager.close();
		}
	}

}
