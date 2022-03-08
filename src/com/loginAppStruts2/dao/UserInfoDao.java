package com.loginAppStruts2.dao;

import com.loginAppStruts2.model.User;

public interface UserInfoDao extends Dao {
    static UserInfoDao getInstance() {
        return new UserInfoDaoImpl();
    }

    boolean addUser(User user);
    User authenticateUser(String username,String password);

}
