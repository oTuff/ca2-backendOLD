package dtos;

import java.util.List;

public class UserDTO {
    private long id;
    private String userName;
    //    private String userPass;
    //    private List<String> roles;
    private List<RoleInnerDto> roles;

    class RoleInnerDto {
        private String roleName;

        public String getRoleName() {
            return roleName;
        }

        public void setRoleName(String roleName) {
            this.roleName = roleName;
        }
    }
}
