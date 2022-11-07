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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
