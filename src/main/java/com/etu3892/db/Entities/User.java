package com.etu3892.db.entities;


public class User {
    private int userId;
    private String username;
    private String password;
    private int teamId;
    private int countryId;
    private String email;
    private boolean admin;

    public User(int userId, String username, String password, int teamId, int countryId, String email) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.teamId = teamId;
        this.countryId = countryId;
        this.email = email;
    }

    public User(int userId, String username, String password, String email) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
