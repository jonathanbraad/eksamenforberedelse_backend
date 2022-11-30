package dtos;

import entities.Meal;
import entities.MealPlan;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A DTO for the {@link entities.MealPlan} entity
 */
public class MealPlanDTO implements Serializable {
    @NotNull
    private Integer id;
    @NotNull
    @Size(max = 45)
    private final String name;
    private final Meal meal;
    @NotNull
    private final Set<UserInnerDTO> users = new HashSet<>();

    public MealPlanDTO(Integer id, String name, Meal meal) {
        this.id = id;
        this.name = name;
        this.meal = meal;
    }

    public MealPlanDTO(MealPlan mealPlan) {
        this.id = mealPlan.getId();
        this.name = mealPlan.getName();
        this.meal = mealPlan.getMeal();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Meal getMeal() {
        return meal;
    }

    public Set<UserInnerDTO> getUsers() {
        return users;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "meal = " + meal + ", " +
                "users = " + users + ")";
    }

    /**
     * A DTO for the {@link entities.User} entity
     */
    public static class UserInnerDTO implements Serializable {
        @NotNull
        private final String userName;
        @NotNull
        @Size(min = 1, max = 255)
        private final String userPass;

        public UserInnerDTO(String userName, String userPass) {
            this.userName = userName;
            this.userPass = userPass;
        }

        public String getUserName() {
            return userName;
        }

        public String getUserPass() {
            return userPass;
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "userName = " + userName + ", " +
                    "userPass = " + userPass + ")";
        }
    }
}