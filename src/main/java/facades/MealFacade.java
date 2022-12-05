package facades;

import dtos.MealDTO;
import entities.Meal;
import entities.MealPlan;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
        TypedQuery<Meal> query = em.createQuery("SELECT m FROM Meal m JOIN m.mealPlans mp WHERE mp.mealPlanName = :meal_plan_name", Meal.class);
        query.setParameter("meal_plan_name", mealPlan);
        query.getResultList().forEach(meal -> {
            mealList.add(new MealDTO(meal));
        });
        return mealList;
    }

    public MealDTO createMeal (MealDTO mealDTO) {
        EntityManager em = getEntityManager();

        //Set<MealPlan> mealPlanSet = new LinkedHashSet<>();
        //mealDTO.getMealPlans().forEach(mealPlanInnerDTO -> {
           // mealPlanSet.add(em.find(MealPlan.class, mealPlanInnerDTO.getId()));
       // });
        Meal newMeal = new Meal(mealDTO.getId(), mealDTO.getRecipeId(), mealDTO.getDay(), mealDTO.getType());
       // newMeal.setMealPlans(mealPlanSet);

        em.getTransaction().begin();
        em.persist(newMeal);
        em.getTransaction().commit();
        em.close();
        return new MealDTO(newMeal);
    }

    public MealDTO updateMeal (MealDTO mealDTO) {
        EntityManager em = getEntityManager();

        Meal meal = em.find(Meal.class, mealDTO.getId());
        if(meal == null) {
            throw new EntityNotFoundException("No such meal with id:" + mealDTO.getId());
        }
        Set<MealPlan> mealPlanSet = new LinkedHashSet<>();
        mealDTO.getMealPlans().forEach(mealPlanInnerDTO -> {
            mealPlanSet.add(em.find(MealPlan.class, mealPlanInnerDTO.getId()));
        });
        Meal updatedMeal = new Meal(mealDTO.getId(), mealDTO.getRecipeId(), mealDTO.getDay(), mealDTO.getType());
        updatedMeal.setMealPlans(mealPlanSet);

        em.getTransaction().begin();
        em.persist(updatedMeal);
        em.getTransaction().commit();
        em.close();
        return new MealDTO(updatedMeal);
    }

    public MealDTO deleteMeal (Integer mealId) {
        EntityManager em = getEntityManager();

        Meal meal = em.find(Meal.class, mealId);
        try {

            em.getTransaction().begin();
            em.remove(meal);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new MealDTO(meal);
    }
}
