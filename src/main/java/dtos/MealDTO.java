package dtos;

import entities.Meal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A DTO for the {@link entities.Meal} entity
 */
public class MealDTO implements Serializable {
    private Integer id;
    @NotNull
    private final Integer recipeId;
    @Size(max = 45)
    @NotNull
    private final String day;
    @Size(max = 45)
    @NotNull
    private final String type;
    private final Set<MealPlanInnerDTO> mealPlans = new HashSet<>();

    public MealDTO(Integer id, Integer recipeId, String day, String type) {
        this.id = id;
        this.recipeId = recipeId;
        this.day = day;
        this.type = type;
    }

    public MealDTO(Meal meal) {
        this.id = meal.getId();
        this.recipeId = meal.getRecipeId();
        this.day = meal.getDay();
        this.type = meal.getType();
    }

    public Integer getId() {
        return id;
    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public String getDay() {
        return day;
    }

    public String getType() {
        return type;
    }

    public Set<MealPlanInnerDTO> getMealPlans() {
        return mealPlans;
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
                "mealPlans = " + mealPlans + ")";
    }

    /**
     * A DTO for the {@link entities.MealPlan} entity
     */
    public static class MealPlanInnerDTO implements Serializable {
        @Size(max = 45)
        private final String id;

        public MealPlanInnerDTO(String id) {
            this.id = id;
        }

        public MealPlanInnerDTO(MealPlanInnerDTO mealPlanInnerDTO) {
            this.id = mealPlanInnerDTO.getId();
        }

        public String getId() {
            return id;
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "id = " + id + ")";
        }
    }
}