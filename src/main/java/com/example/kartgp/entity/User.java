package com.example.kartgp.entity;

public class User {

    //region properties
    private int id;
    private String username;
    private String password;
    private String role;
    //endregion

    //region constructor

    public User(int id, String username, String role) {
        this.id = id;
        this.username = username;
        this.role = role;
    }

    public User(int id, String username) {
        this.id = id;
        this.username = username;
    }

    //endregion

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
    //endregion

}
