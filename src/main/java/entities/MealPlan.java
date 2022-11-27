package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "meal_plan")
public class MealPlan {
    @Id
    @Size(max = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meal_plan_name", nullable = false, length = 45)
    private String id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "meal_id", nullable = false)
    private Meal meal;

    @ManyToMany
    @JoinTable(name = "user_meal_plan",
            joinColumns = @JoinColumn(name = "meal_plan_name"),
            inverseJoinColumns = @JoinColumn(name = "user_name"))
    private Set<User> users = new LinkedHashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

}