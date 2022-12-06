package dtos;

import entities.Meal;
import entities.MealPlan;
import entities.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A DTO for the {@link entities.MealPlan} entity
 */
public class MealPlanDTO implements Serializable {

    private Integer id;
    @Size(max = 45)
    @NotNull
    private final String mealPlanName;
    private final Meal meal;
    @NotNull
    private List<User> users = new ArrayList<>();

    public MealPlanDTO(Integer id, String mealPlanName, Meal meal) {
        this.id = id;
        this.mealPlanName = mealPlanName;
        this.meal = meal;
    }

    public MealPlanDTO(MealPlan mealPlan) {
        this.id = mealPlan.getId();
        this.mealPlanName = mealPlan.getMealPlanName();
        this.meal = mealPlan.getMeal();
        this.users = mealPlan.getUsers();
    }


    public Integer getId() {
        return id;
    }

    public Meal getMeal() {
        return meal;
    }

    public String getMealPlanName() {
        return mealPlanName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setId(Integer  id) {
        this.id = id;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + mealPlanName + ", " +
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