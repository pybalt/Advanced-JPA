package utils;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
    private final static EntityManagerFactory FACTORY = Persistence.
            createEntityManagerFactory("store");
    public static EntityManager getEntityManager(){
        return JPAUtils.FACTORY.createEntityManager();
    }
}
