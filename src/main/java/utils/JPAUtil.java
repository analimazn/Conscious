package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	protected static EntityManager entityManager;
	
	public static EntityManager getEntityManager() {
	    EntityManagerFactory factory = 
	    Persistence.createEntityManagerFactory("persistence_conscious");
	    if (entityManager == null) {
	    	System.out.println("The entity manager is created");
	    	entityManager = factory.createEntityManager();
	    }
	 
	    return entityManager;
   }
	
	public static void shutdown() {
		if (entityManager != null) {
			System.out.println("The connection is closed");
			entityManager.close();
		}
	}
}
