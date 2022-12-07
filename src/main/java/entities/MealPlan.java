package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "meal_plan")
public class MealPlan {

    public MealPlan() {
    }

    public MealPlan(Integer id, String mealPlanName, Meal meal) {
        this.id = id;
        this.mealPlanName = mealPlanName;
        this.meal = meal;
    }

    public MealPlan(Integer id, String mealPlanName, Meal meal, List<User> users) {
        this.id = id;
        this.mealPlanName = mealPlanName;
        this.meal = meal;
        this.users = users;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meal_plan_id", nullable = false)
    private Integer id;

    @Size(max = 45)
    @NotNull
    @Column(name = "meal_plan_name", nullable = false, length = 45)
    private String mealPlanName;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "meal_id", nullable = false)
    private Meal meal;

    @ManyToMany
    @JoinTable(name = "user_meal_plan",
            joinColumns = @JoinColumn(name = "meal_plan_id"),
            inverseJoinColumns = @JoinColumn(name = "user_name"))
    private List<User> users = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMealPlanName() {
        return mealPlanName;
    }

    public void setMealPlanName(String mealPlanName) {
        this.mealPlanName = mealPlanName;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}