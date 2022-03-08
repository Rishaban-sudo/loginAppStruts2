package com.loginAppStruts2.dao;

import com.loginAppStruts2.utils.MySqlConnection;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class DaoImpl implements Dao {
    protected Connection con = null;

    @Override
    public void connect() {
        try {
            con = MySqlConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void disconnect() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
