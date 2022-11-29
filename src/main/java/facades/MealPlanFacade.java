package facades;

import dtos.MealPlanDTO;
import entities.MealPlan;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class MealPlanFacade {

    private static MealPlanFacade instance;
    private static EntityManagerFactory emf;

    private MealPlanFacade() {
    }

    public static MealPlanFacade getMealPlanFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MealPlanFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<MealPlanDTO> getAllMealPlansByUser(String username) {
        List<MealPlanDTO> mealPlanList = new ArrayList<>();
        EntityManager em = getEntityManager();
        TypedQuery<MealPlan> query = em.createQuery("SELECT m FROM MealPlan m JOIN m.users u WHERE u.userName = :user_name", MealPlan.class);
        query.setParameter("user_name", username);
        query.getResultList().forEach(mealPlan -> {
            mealPlanList.add(new MealPlanDTO(mealPlan));
        });
        return mealPlanList;
    }
}
