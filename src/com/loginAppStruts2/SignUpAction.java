package com.loginAppStruts2;

import com.loginAppStruts2.dao.UserInfoDao;
import com.loginAppStruts2.model.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang.StringUtils;

public class SignUpAction extends ActionSupport implements ModelDriven<User> {

    private User user = new User();
    private String errorMessage;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public void validate() {
        if (StringUtils.isEmpty(user.getUserName())) {
            addFieldError("userName","User Name cannot be blank!!");
        }
        if (StringUtils.isEmpty(user.getPassword())) {
            addFieldError("password","Password cannot be blank!!");
        }
    }

    @Override
    public String execute() throws Exception {

        UserInfoDao userInfoDao = UserInfoDao.getInstance();

        try {

            userInfoDao.connect();

            System.out.println(user.getUserName());

            if (userInfoDao.addUser(user)) {
                return SUCCESS;
            }
            else {
                errorMessage = "User name already exists!!";
                return ERROR;
            }
        } finally {
            userInfoDao.disconnect();
        }

    }

    @Override
    public User getModel() {
        return user;
    }
}
