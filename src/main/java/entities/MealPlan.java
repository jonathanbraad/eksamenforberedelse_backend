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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meal_plan_id", nullable = false)
    private Integer id;

    @Size(max = 45)
    @NotNull
    @Column(name = "meal_plan_name", nullable = false, length = 45)
    private String mealPlanName;

    @OneToMany(mappedBy = "mealPlan")
    private Set<Meal> meals = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "user_meal_plan",
            joinColumns = @JoinColumn(name = "meal_plan_id"),
            inverseJoinColumns = @JoinColumn(name = "user_name"))
    private List<User> users = new ArrayList<>();

    public MealPlan() {
    }

    public MealPlan(Integer id, String mealPlanName) {
        this.id = id;
        this.mealPlanName = mealPlanName;
    }

    public MealPlan(Integer id, String mealPlanName, List<User> users) {
        this.id = id;
        this.mealPlanName = mealPlanName;
        this.users = users;
    }

    public MealPlan(Integer id, String mealPlanName, Set<Meal> meals, List<User> users) {
        this.id = id;
        this.mealPlanName = mealPlanName;
        this.meals = meals;
        this.users = users;
    }

    public Set<Meal> getMeals() {
        return meals;
    }

    public void setMeals(Set<Meal> meals) {
        this.meals = meals;
    }

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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}