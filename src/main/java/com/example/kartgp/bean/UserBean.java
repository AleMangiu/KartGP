package com.example.kartgp.bean;

public class UserBean {

    //region properties
    private int id;
    private String username;
    private String password;
    private String role;
    private String checkPassword;
    //endregion

    //region constructor
    public UserBean(int id, String username, String role) {
        this.id = id;
        this.username = username;
        this.role = role;
    }

    public UserBean() {

    }
    //endregions

    //region getter setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setCheckPassword(String checkPassword) { this.checkPassword = checkPassword; }

    public String getCheckPassword() {return checkPassword; }
    //endregion

    //region methods

    public void checkField(String username, String password) throws IllegalArgumentException{
        if (username.isEmpty() || password.isEmpty()) {
            throw new IllegalArgumentException("Please fill all the fields");
        }
    }

    public void checkIfPassIsEqual(String password, String checkPassword) throws IllegalArgumentException {
        if (!password.equals(checkPassword)) {
            throw new IllegalArgumentException("password is not Equal");
        }
    }

    //endregion

}
