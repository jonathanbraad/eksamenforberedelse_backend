package dtos;

import entities.Meal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link entities.Meal} entity
 */
public class MealDTO implements Serializable {
    private Integer id;
    @NotNull
    private final long recipeId;
    @Size(max = 45)
    @NotNull
    private final String day;
    @Size(max = 45)
    @NotNull
    private final String type;
    @NotNull
    private final MealPlanDTO mealPlan;

    public MealDTO(Integer id, long recipeId, String day, String type, MealPlanDTO mealPlan) {
        this.id = id;
        this.recipeId = recipeId;
        this.day = day;
        this.type = type;
        this.mealPlan = mealPlan;
    }

    public MealDTO(Meal meal) {
        this.id = meal.getId();
        this.recipeId = meal.getRecipeId();
        this.day = meal.getDay();
        this.type = meal.getType();
        this.mealPlan = new MealPlanDTO(meal.getMealPlan());
    }

    public Integer getId() {
        return id;
    }

    public long getRecipeId() {
        return recipeId;
    }

    public String getDay() {
        return day;
    }

    public String getType() {
        return type;
    }

    public MealPlanDTO getMealPlans() {
        return mealPlan;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "recipeId = " + recipeId + ", " +
                "day = " + day + ", " +
                "type = " + type + ", " +
                "mealPlans = " + mealPlan + ")";
    }
}