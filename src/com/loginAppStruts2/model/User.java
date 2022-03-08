package com.loginAppStruts2.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private int userId;
    private String userName;
    private String password;

    public User() {

    }

    public User(int userId, String userName, String password) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }

    public static User fromResultSet(ResultSet rs) throws SQLException {
        return new User(rs.getInt(1),rs.getString(2),rs.getString(3));
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
