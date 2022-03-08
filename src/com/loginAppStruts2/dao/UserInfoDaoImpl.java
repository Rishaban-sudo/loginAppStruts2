package com.loginAppStruts2.dao;

import com.loginAppStruts2.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserInfoDaoImpl extends DaoImpl implements UserInfoDao {

    @Override
    public boolean addUser(User user) {
        try (PreparedStatement st = con.prepareStatement("INSERT INTO USER_INFO(user_id, user_name, password)\n" +
                                                         "VALUES (NULL,?,?);")) {
            st.setString(1, user.getUserName());
            st.setString(2, user.getPassword());

            st.executeUpdate();

            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User authenticateUser(String username, String password) {

        try (PreparedStatement st = con.prepareStatement("SELECT * FROM USER_INFO WHERE user_name = ? AND password = ?;")) {

            st.setString(1,username);
            st.setString(2,password);

            try(ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    return User.fromResultSet(rs);
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
