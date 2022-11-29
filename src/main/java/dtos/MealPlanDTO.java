package dtos;

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
    @Size(max = 45)
    private final String name;
    private final Set<UserInnerDTO> users = new HashSet<>();

    public MealPlanDTO(String name) {
        this.name = name;
    }

    public MealPlanDTO(MealPlan mealPlan) {
        this.name = mealPlan.getName();
    }

    public String getName() {
        return name;
    }

    public Set<UserInnerDTO> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "name = " + name + ", " +
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