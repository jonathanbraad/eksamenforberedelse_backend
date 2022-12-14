package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "meal")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meal_id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "recipe_id", nullable = false)
    private Long recipeId;

    @Size(max = 45)
    @NotNull
    @Column(name = "day", nullable = false, length = 45)
    private String day;

    @Size(max = 45)
    @NotNull
    @Column(name = "type", nullable = false, length = 45)
    private String type;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "meal_plan_id", nullable = false)
    private MealPlan mealPlan;


    public Meal() {
    }

    public Meal(Integer id, long recipeId, String day, String type) {
        this.id = id;
        this.recipeId = recipeId;
        this.day = day;
        this.type = type;
    }

    public Meal(Integer id, long recipeId, String day, String type, MealPlan mealPlan) {
        this.id = id;
        this.recipeId = recipeId;
        this.day = day;
        this.type = type;
        this.mealPlan = mealPlan;
    }

    public MealPlan getMealPlan() {
        return mealPlan;
    }

    public void setMealPlan(MealPlan mealPlan) {
        this.mealPlan = mealPlan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}