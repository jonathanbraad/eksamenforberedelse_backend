package facades;

import dtos.MealDTO;
import dtos.MealPlanDTO;
import entities.Meal;
import entities.MealPlan;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

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

    public List<MealDTO> getAllMealsByMealPlan(String mealPlan) {
        List<MealDTO> mealList = new ArrayList<>();
        EntityManager em = getEntityManager();
        TypedQuery<Meal> query = em.createQuery("SELECT m FROM Meal m JOIN m.mealPlans mp WHERE mp.name = :meal_plan_name", Meal.class);
        query.setParameter("meal_plan_name", mealPlan);
        query.getResultList().forEach(meal -> {
            mealList.add(new MealDTO(meal));
        });
        return mealList;
    }
}
