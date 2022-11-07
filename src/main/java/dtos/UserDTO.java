package dtos;

import entities.User;

import java.util.List;

public class UserDTO {
    private long id;
    private String userName;
    private String userPass;
    private List<String> roles;

    public UserDTO(User u){
        this.id = u.getId();
        this.userName = u.getUserName();
        this.userPass = u.getUserPass();
        this.roles = u.getRolesAsStrings();
    }
}
