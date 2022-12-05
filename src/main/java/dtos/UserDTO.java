package dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link entities.User} entity
 */
public class UserDTO implements Serializable {
    @NotNull
    private final String userName;
    @NotNull
    @Size(min = 1, max = 255)
    private final String userPass;
    private final List<RoleDto> roleList;

    public UserDTO(String userName, String userPass, List<RoleDto> roleList) {
        this.userName = userName;
        this.userPass = userPass;
        this.roleList = roleList;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public List<RoleDto> getRoleList() {
        return roleList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO entity = (UserDTO) o;
        return Objects.equals(this.userName, entity.userName) &&
                Objects.equals(this.userPass, entity.userPass) &&
                Objects.equals(this.roleList, entity.roleList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, userPass, roleList);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "userName = " + userName + ", " +
                "userPass = " + userPass + ", " +
                "roleList = " + roleList + ")";
    }

    /**
     * A DTO for the {@link entities.Role} entity
     */
    public static class RoleDto implements Serializable {
        @NotNull
        private final String roleName;

        public RoleDto(String roleName) {
            this.roleName = roleName;
        }

        public String getRoleName() {
            return roleName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            RoleDto entity = (RoleDto) o;
            return Objects.equals(this.roleName, entity.roleName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(roleName);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "roleName = " + roleName + ")";
        }
    }
}