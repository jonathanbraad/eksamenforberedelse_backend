package facades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class MealFacade {

    private static MealFacade instance;
    private static EntityManagerFactory emf;

    private MealFacade() {
    }

    public static MealFacade getMealFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MealFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
