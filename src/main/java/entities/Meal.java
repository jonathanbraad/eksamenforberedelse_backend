package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "meal")
public class Meal {

    public Meal() {
    }

    public Meal(Integer id, long recipeId, String day, String type) {
        this.id = id;
        this.recipeId = recipeId;
        this.day = day;
        this.type = type;
    }

    public Meal(Integer id, long recipeId, String day, String type, Set<MealPlan> mealPlans) {
        this.id = id;
        this.recipeId = recipeId;
        this.day = day;
        this.type = type;
        this.mealPlans = mealPlans;
    }

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

    @OneToMany(mappedBy = "meal")
    private Set<MealPlan> mealPlans = new LinkedHashSet<>();

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

    public Set<MealPlan> getMealPlans() {
        return mealPlans;
    }

    public void setMealPlans(Set<MealPlan> mealPlans) {
        this.mealPlans = mealPlans;
    }

}